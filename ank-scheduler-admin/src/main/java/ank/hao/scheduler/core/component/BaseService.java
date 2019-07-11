package ank.hao.scheduler.core.component;

import ank.hao.scheduler.core.enums.RouteStategyEnum;
import ank.hao.scheduler.core.exception.InternalServerException;
import ank.hao.scheduler.domain.MlSchedulerGroupDetail;
import ank.hao.scheduler.domain.MlSchedulerGroupDetailExample;
import ank.hao.scheduler.mapper.*;
import ank.hao.scheduler.mapper.ext.MlSchedulerExtMapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class BaseService implements InitializingBean {

    private static BaseService baseService;

    public static BaseService getBaseService() {
        return baseService;
    }

    @Override
    public void afterPropertiesSet() {
        baseService = this;
    }

    @Value("${ank.scheduler.heartbeat-interval}")
    private String heartbeat_interval;

    @Autowired
    protected MlSchedulerGroupMapper mlSchedulerGroupMapper;
    @Autowired
    protected MlSchedulerTaskMapper mlSchedulerTaskMapper;
    @Autowired
    protected MlSchedulerGroupDetailMapper mlSchedulerGroupDetailMapper;
    @Autowired
    protected MlSchedulerExtMapper mlSchedulerExtMapper;
    @Autowired
    protected MlSchedulerJobMapper mlSchedulerJobMapper;
    @Autowired
    protected MlSchedulerTaskInstanceMapper mlSchedulerTaskInstanceMapper;
    @Autowired
    protected MlSchedulerTaskInstanceLogMapper mlSchedulerTaskInstanceLogMapper;
    @Autowired
    protected MlSchedulerJobLogMapper mlSchedulerJobLogMapper;

    @Autowired
    protected UserClient userClient;

    @Autowired
    protected ApplicationContext applicationContext;

    @Autowired
    protected SchedulerFactoryBean schedulerFactoryBean;

    protected String routeUrl(String appName, Integer route){

        List<String> addressList = new ArrayList<>();
        MlSchedulerGroupDetailExample mlSchedulerGroupDetailExample = new MlSchedulerGroupDetailExample();
        mlSchedulerGroupDetailExample.createCriteria().andAppNameEqualTo(appName);
        List<MlSchedulerGroupDetail> mlSchedulerGroupDetailList = mlSchedulerGroupDetailMapper.selectByExample(mlSchedulerGroupDetailExample);
        if(CollectionUtils.isEmpty(mlSchedulerGroupDetailList)){
            throw new InternalServerException("找不到可用执行器：{}",appName);
        }
        for(MlSchedulerGroupDetail mlSchedulerGroupDetail:mlSchedulerGroupDetailList){
            addressList.add(mlSchedulerGroupDetail.getAddress());
        }

        RouteStategyEnum routeStategyEnum = RouteStategyEnum.getRouteStategy(route);
        return routeStategyEnum.getRouteStategy().getRouteAddress(addressList);
    }

    public MlSchedulerExtMapper getMlSchedulerExtMapper() {
        return mlSchedulerExtMapper;
    }

    public MlSchedulerGroupMapper getMlSchedulerGroupMapper() {
        return mlSchedulerGroupMapper;
    }

    public MlSchedulerGroupDetailMapper getMlSchedulerGroupDetailMapper() {
        return mlSchedulerGroupDetailMapper;
    }

    public MlSchedulerTaskMapper getMlSchedulerTaskMapper() {
        return mlSchedulerTaskMapper;
    }

    public String getHeartbeat_interval() {
        return heartbeat_interval;
    }

    public MlSchedulerJobMapper getMlSchedulerJobMapper() {
        return mlSchedulerJobMapper;
    }

    public SchedulerFactoryBean getSchedulerFactoryBean() {
        return schedulerFactoryBean;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public MlSchedulerTaskInstanceMapper getMlSchedulerTaskInstanceMapper() {
        return mlSchedulerTaskInstanceMapper;
    }

    public UserClient getUserClient() {
        return userClient;
    }

    public MlSchedulerJobLogMapper getMlSchedulerJobLogMapper() {
        return mlSchedulerJobLogMapper;
    }

    public MlSchedulerTaskInstanceLogMapper getMlSchedulerTaskInstanceLogMapper() {
        return mlSchedulerTaskInstanceLogMapper;
    }
}
