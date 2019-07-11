package ank.hao.scheduler.core.schedule;

import ank.hao.scheduler.core.component.BaseService;
import ank.hao.scheduler.core.component.SystemConstant;
import ank.hao.scheduler.domain.MlSchedulerJob;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface MyScheduler {

    Logger logger = LoggerFactory.getLogger(MyScheduler.class);

    void run(MlSchedulerJob job);

    default void stop(MlSchedulerJob job){
        Scheduler scheduler = BaseService.getBaseService().getSchedulerFactoryBean().getScheduler();
        JobKey jobKey = JobKey.jobKey(SystemConstant.JOB_KEY_PREFIX+job.getJobId());
        try {
            scheduler.deleteJob(jobKey);
        } catch (SchedulerException e) {
            logger.error("停止调度任务失败，errMsg is: "+e.getMessage());
        }
    }
}
