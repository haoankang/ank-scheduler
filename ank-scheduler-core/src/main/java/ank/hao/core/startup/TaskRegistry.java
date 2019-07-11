package ank.hao.core.startup;

import ank.hao.core.annotation.AnkTask;
import ank.hao.core.component.BaseComponent;
import ank.hao.core.feign.SchedulerFeign;
import ank.hao.core.log.ExecutorLog;
import ank.hao.core.task.IAnkTask;
import ank.hao.core.util.FeignUtil;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * 执行器初始化和关闭流程
 * 这里使用spring框架的监听事件，而不是web的ApplicationRunner，是因为方便以后扩展执行器的可插拔机制
 */
@Component
@ConditionalOnMissingClass("ank.hao.scheduler.SchedulerApplication")
public class TaskRegistry implements ApplicationRunner {

    public static final ConcurrentHashMap<String,IAnkTask> serviceMap = new ConcurrentHashMap<String,IAnkTask>(20);

    public static final ConcurrentHashMap<Integer, IAnkTask> serviceStopMap = new ConcurrentHashMap<>(50);

    @Value("${spring.application.name}")
    private String executorName;

    @Value("${server.port}")
    private String executorPort;

    @Value("${ank.scheduler.address:}")
    private String schedulerAddress;

    @Value("${ank.executor.heartbeat-interval:30}")
    private String heartbeat_interval;

    @Autowired
    private ApplicationContext applicationContext;

    public void run(ApplicationArguments event) {

        //系统启动或初始化时
        if(!StringUtils.isEmpty(schedulerAddress)){

            //心跳监听调度中心可用地址
            new Thread(()->{
                while (true){
                    List<String> urlList = new ArrayList<>();
                    for(String url: schedulerAddress.split(",")){
                        SchedulerFeign schedulerFeign1 = (SchedulerFeign) FeignUtil.getFeignClient(SchedulerFeign.class, url);
                        try {
                            schedulerFeign1.heartbeat();
                            urlList.add(url);
                        } catch (Exception e){
                            ExecutorLog.errorLog("调度中心机器丢失，url--{}",url);
                        }
                    }
                    BaseComponent.getBaseComponent().setAddressList(urlList);

                    try {
                        TimeUnit.SECONDS.sleep(Long.parseLong(heartbeat_interval));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            //确保先获取到可用调度中心地址
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //获取执行器机器ip地址
            String executorAddress = null;
            try {
                executorAddress = InetAddress.getLocalHost().getHostAddress()+":"+executorPort;
            } catch (UnknownHostException e) {
                ExecutorLog.errorLog("获取本地机器IP地址失败，原因：{}", e.getMessage());
            }
            //注册执行器
            JSONObject registryExecutorParam = new JSONObject();
            registryExecutorParam.put("executorName",executorName);
            registryExecutorParam.put("executorAddress",executorAddress);
            SchedulerFeign schedulerFeign = BaseComponent.getBaseComponent().getSchedulerFeign();
            JSONObject jsonObject = schedulerFeign.registryExecutor(registryExecutorParam.toJSONString());
            String result = jsonObject.getString("result");
            if(!"SUCCESS".equals(result)){
                ExecutorLog.errorLog("注册执行器失败");
            }

            //注册执行器服务
            Map<String, Object> taskMap = applicationContext.getBeansWithAnnotation(AnkTask.class);
            if(!CollectionUtils.isEmpty(taskMap)){
                for(Map.Entry<String,Object> entry:taskMap.entrySet()){
                    String serviceName = entry.getKey();
                    Object serviceBean = entry.getValue();
                    String desc = serviceBean.getClass().getAnnotation(AnkTask.class).desc();
                    if(serviceBean instanceof IAnkTask){
                        IAnkTask ankTask = (IAnkTask) serviceBean;
                        //向调度中心注册
                        JSONObject registryServiceParam = new JSONObject();
                        registryServiceParam.put("executorName", executorName);
                        registryServiceParam.put("taskName", serviceName);
                        registryServiceParam.put("taskDesc", desc);
                        schedulerFeign.registryService(registryServiceParam.toJSONString());
                        //服务放入缓存用于调用执行
                        serviceMap.put(serviceName,ankTask);
                    }
                    ExecutorLog.infoLog("注册器注册服务:{}",serviceName);
                }
            }

        }
    }
}
