package ank.hao.scheduler.mapper.ext;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface MlSchedulerExtMapper {

    @Select("SELECT DISTINCT t.APP_NAME FROM ml_scheduler_task t where t.APP_NAME not in(SELECT DISTINCT APP_NAME from ml_scheduler_group_detail)")
    List<String> selectTaskIsLost();

    @Select("select tt.TASK_INSTANCE_LOG_ID from ml_scheduler_task_instance_log tt, (select min(TASK_INSTANCE_LOG_ID) as ID from ml_scheduler_task_instance_log where TASK_STATE in(0,3) group by DEPEND_ID) ts where tt.TASK_INSTANCE_LOG_ID = ts.ID and tt.TASK_STATE = 3")
    List<Integer> taskToRunList();

//    @Select("SELECT tt.TIMEOUT,ts.TASKRUN_ID,ts.START_TIME FROM `ml_schedule_task` tt,ml_schedule_task_run ts where tt.TASK_ID=ts.TASK_ID AND tt.TIMEOUT>0 and ts.START_TIME is not null and ts.`STATUS`=0 and tt.STATE=1 and tt.DELETE_FLAG=0")
//    List<Map<String,Object>> taskMaybeTimeout();
}
