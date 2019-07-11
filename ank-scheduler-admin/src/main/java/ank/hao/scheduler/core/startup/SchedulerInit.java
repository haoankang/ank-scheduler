package ank.hao.scheduler.core.startup;

import ank.hao.scheduler.core.component.BaseService;
import ank.hao.scheduler.core.enums.HandleStateEnum;
import ank.hao.scheduler.core.enums.RegistryTypeEnum;
import ank.hao.scheduler.core.thread.HeartbeatThread;
import ank.hao.scheduler.core.thread.JobRunDaemonThread;
import ank.hao.scheduler.domain.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class SchedulerInit extends BaseService implements ApplicationRunner {

    public void run(ApplicationArguments args) {
        //清空执行器自动注册表
        MlSchedulerGroupExample mlSchedulerGroupExample = new MlSchedulerGroupExample();
        mlSchedulerGroupExample.createCriteria().andAddressTypeEqualTo(RegistryTypeEnum.AUTO.getCode());
        mlSchedulerGroupMapper.deleteByExample(mlSchedulerGroupExample);

        mlSchedulerGroupDetailMapper.deleteByExample(new MlSchedulerGroupDetailExample());
        //清空执行器服务自动注册表
        MlSchedulerTaskExample mlSchedulerTaskExample = new MlSchedulerTaskExample();
        mlSchedulerTaskExample.createCriteria().andTaskSourceEqualTo(RegistryTypeEnum.AUTO.getCode());
        mlSchedulerTaskMapper.deleteByExample(mlSchedulerTaskExample);

        //执行器心跳监听
        new Thread(new HeartbeatThread()).start();

        List<Integer> statusList = new ArrayList<>();
        statusList.add(HandleStateEnum.FAIL.getCode());
        statusList.add(HandleStateEnum.SUCCESS.getCode());
        MlSchedulerTaskInstanceLogExample scheduleRunDetailExample = new MlSchedulerTaskInstanceLogExample();
        scheduleRunDetailExample.createCriteria().andTaskStateNotIn(statusList);
        MlSchedulerTaskInstanceLog scheduleRunDetail2 = new MlSchedulerTaskInstanceLog();
        scheduleRunDetail2.setTaskState(HandleStateEnum.FAIL.getCode());
        mlSchedulerTaskInstanceLogMapper.updateByExampleSelective(scheduleRunDetail2,scheduleRunDetailExample);

        MlSchedulerJobLogExample scheduleTaskRunExample = new MlSchedulerJobLogExample();
        scheduleTaskRunExample.createCriteria().andJobHandleStateNotIn(statusList);
        MlSchedulerJobLog mlSchedulerJobLog = new MlSchedulerJobLog();
        mlSchedulerJobLog.setJobHandleState(HandleStateEnum.FAIL.getCode());
        mlSchedulerJobLog.setJobHandleMsg("启动初始化");
        mlSchedulerJobLog.setJobHandleFinishTime(new Date());
        mlSchedulerJobLogMapper.updateByExampleSelective(mlSchedulerJobLog, scheduleTaskRunExample);
        //启动作业执行线程
        new Thread(new JobRunDaemonThread()).start();
    }
}
