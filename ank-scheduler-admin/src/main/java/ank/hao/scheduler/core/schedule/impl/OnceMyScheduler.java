package ank.hao.scheduler.core.schedule.impl;

import ank.hao.scheduler.core.component.BaseService;
import ank.hao.scheduler.core.component.SystemConstant;
import ank.hao.scheduler.core.hanndler.impl.CronTaskHandler;
import ank.hao.scheduler.core.schedule.MyScheduler;
import ank.hao.scheduler.domain.MlSchedulerJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("onceScheduler")
public class OnceMyScheduler implements MyScheduler {

    private static final Logger logger = LoggerFactory.getLogger(OnceMyScheduler.class);

    @Override
    public void run(MlSchedulerJob job) {

        try {
            Scheduler scheduler = BaseService.getBaseService().getSchedulerFactoryBean().getScheduler();
            JobDetail jobDetail = JobBuilder.newJob(CronTaskHandler.class).withIdentity(SystemConstant.JOB_KEY_PREFIX+job.getJobId())
                    .build();
            jobDetail.getJobDataMap().put("job",job);
            Trigger trigger = new SimpleTriggerImpl();
            ((SimpleTriggerImpl) trigger).setName(job.getJobName());
            ((SimpleTriggerImpl) trigger).setStartTime(new Date());
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (Exception e) {
            logger.error("调度任务失败，errMsg is: "+e.getMessage());
        }

    }
}
