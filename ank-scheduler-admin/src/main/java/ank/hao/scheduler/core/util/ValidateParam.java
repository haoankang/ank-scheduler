package ank.hao.scheduler.core.util;

import ank.hao.scheduler.controller.model.ConditionInfo;
import ank.hao.scheduler.controller.model.JobAddVO;
import ank.hao.scheduler.controller.model.JobUpdateVO;
import ank.hao.scheduler.controller.model.TaskListInfo;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

public class ValidateParam {

    public static String validate_TaskAddVO(JobAddVO jobAddVO){
        ConditionInfo conditionInfo = jobAddVO.getConditionInfo();

        TaskListInfo taskBaseInfo = jobAddVO.getJobBaseInfo();
        if(taskBaseInfo==null || CollectionUtils.isEmpty(taskBaseInfo)){
            return "没有可执行的任务";
        }

        if(StringUtils.isEmpty(conditionInfo.getIndateStartTime()) || StringUtils.isEmpty(conditionInfo.getIndateEndTime())){
            return "有效期不能为空";
        }

        if(jobAddVO.getComment().length()>255){
            return "备注字符长度不能超过255个";
        }

        if(jobAddVO.getJobName().length()>20){
            return "任务名称长度不能超过20个";
        }

        return "ok";
    }

    public static String validate_TaskUpdateVO(JobUpdateVO jobUpdateVO){
        Integer jobId = jobUpdateVO.getJobId();
        JobAddVO jobAddVO = jobUpdateVO.getJobAddVO();
        if(StringUtils.isEmpty(jobId)){
            return "taskId can not be null";
        }
        return validate_TaskAddVO(jobAddVO);
    }
}
