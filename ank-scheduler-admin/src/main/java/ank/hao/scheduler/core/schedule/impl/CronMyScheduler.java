package ank.hao.scheduler.core.schedule.impl;

import ank.hao.scheduler.controller.model.ConditionInfo;
import ank.hao.scheduler.core.component.BaseService;
import ank.hao.scheduler.core.component.SystemConstant;
import ank.hao.scheduler.core.hanndler.impl.CronTaskHandler;
import ank.hao.scheduler.core.schedule.MyScheduler;
import ank.hao.scheduler.domain.MlSchedulerJob;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

@Component("cronScheduler")
@Slf4j
public class CronMyScheduler implements MyScheduler {

    @Override
    public void run(MlSchedulerJob job) {

        try {
            ConditionInfo conditionInfo = JSON.parseObject(job.getConditionInfo(), ConditionInfo.class);
            Long indateStartTime = conditionInfo.getIndateStartTime();
            Long indateEndTime = conditionInfo.getIndateEndTime();

            Scheduler scheduler = BaseService.getBaseService().getSchedulerFactoryBean().getScheduler();
            JobDetail jobDetail = JobBuilder.newJob(CronTaskHandler.class).withIdentity(SystemConstant.JOB_KEY_PREFIX+job.getJobId())
                    .build();
            jobDetail.getJobDataMap().put("job",JSON.toJSONString(job));
            CronTrigger trigger = new CronTriggerImpl();
            ((CronTriggerImpl) trigger).setName(job.getJobName());
            ((CronTriggerImpl) trigger).setCronExpression(job.getCronExpression());
            //set the indate time
            if(indateStartTime!=-1){
                ((CronTriggerImpl) trigger).setStartTime(new Date(indateStartTime));
            }
            if(indateEndTime!=-1){
                ((CronTriggerImpl) trigger).setEndTime(new Date(indateEndTime));
            }
            //MISFIRE STRATEGY
            //((CronTriggerImpl) trigger).setMisfireInstruction(CronTrigger.MISFIRE_INSTRUCTION_DO_NOTHING);
            if(job.getRunimmediately()){
                ((CronTriggerImpl) trigger).setMisfireInstruction(CronTrigger.MISFIRE_INSTRUCTION_SMART_POLICY);
            }else {
                ((CronTriggerImpl) trigger).setMisfireInstruction(CronTrigger.MISFIRE_INSTRUCTION_DO_NOTHING);
            }
            //设置时区
            ((CronTriggerImpl) trigger).setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));
            scheduler.scheduleJob(jobDetail, trigger);
            log.info("新增调度作业： "+job.getJobName());
        } catch (Exception e) {
            log.error("调度作业失败，errMsg is: "+e.getMessage());
        }

    }
}
