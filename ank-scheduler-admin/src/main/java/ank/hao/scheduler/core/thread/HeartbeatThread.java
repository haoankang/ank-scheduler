package ank.hao.scheduler.core.thread;

import ank.hao.core.log.ExecutorLog;
import ank.hao.core.util.FeignUtil;
import ank.hao.scheduler.core.component.BaseService;
import ank.hao.scheduler.core.feign.ExecutorFeign;
import ank.hao.scheduler.domain.MlSchedulerGroupDetail;
import ank.hao.scheduler.domain.MlSchedulerGroupDetailExample;
import ank.hao.scheduler.domain.MlSchedulerTaskExample;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HeartbeatThread implements Runnable {

    @Override
    public void run() {

        while (true){
            try {
                List<MlSchedulerGroupDetail> mlSchedulerGroupDetails = BaseService.getBaseService().getMlSchedulerGroupDetailMapper().selectByExample(new MlSchedulerGroupDetailExample());
                for(MlSchedulerGroupDetail mlSchedulerGroupDetail:mlSchedulerGroupDetails){
                    ExecutorFeign executorFeign = (ExecutorFeign) FeignUtil.getFeignClientAddHttp(ExecutorFeign.class, mlSchedulerGroupDetail.getAddress());
                    try {
                        executorFeign.heartBeat();
                    }catch (Exception e){
                        //删除离线机器节点
                        ExecutorLog.infoLog("机器丢失：appName-{},ip-{}", mlSchedulerGroupDetail.getAppName(), mlSchedulerGroupDetail.getAddress());
                        BaseService.getBaseService().getMlSchedulerGroupDetailMapper().deleteByPrimaryKey(mlSchedulerGroupDetail.getId());
                    }
                }

                //如果一个执行器的所有节点都挂掉，删除服务列表
                List<String> appNameList = BaseService.getBaseService().getMlSchedulerExtMapper().selectTaskIsLost();
                if(!CollectionUtils.isEmpty(appNameList)){
                    MlSchedulerTaskExample mlSchedulerTaskExample = new MlSchedulerTaskExample();
                    mlSchedulerTaskExample.createCriteria().andAppNameIn(appNameList);
                    BaseService.getBaseService().getMlSchedulerTaskMapper().deleteByExample(mlSchedulerTaskExample);
                }

                TimeUnit.SECONDS.sleep(Long.parseLong(BaseService.getBaseService().getHeartbeat_interval()));
            } catch (Exception e) {
                ExecutorLog.errorLog("心跳线程异常：{}", e.getMessage());
            }
        }
    }
}
