package ank.hao.scheduler.mapper;

import ank.hao.scheduler.domain.MlSchedulerTaskInstance;
import ank.hao.scheduler.domain.MlSchedulerTaskInstanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlSchedulerTaskInstanceMapper {
    long countByExample(MlSchedulerTaskInstanceExample example);

    int deleteByExample(MlSchedulerTaskInstanceExample example);

    int deleteByPrimaryKey(Integer taskInstanceId);

    int insert(MlSchedulerTaskInstance record);

    int insertSelective(MlSchedulerTaskInstance record);

    List<MlSchedulerTaskInstance> selectByExampleWithBLOBs(MlSchedulerTaskInstanceExample example);

    List<MlSchedulerTaskInstance> selectByExample(MlSchedulerTaskInstanceExample example);

    MlSchedulerTaskInstance selectByPrimaryKey(Integer taskInstanceId);

    int updateByExampleSelective(@Param("record") MlSchedulerTaskInstance record, @Param("example") MlSchedulerTaskInstanceExample example);

    int updateByExampleWithBLOBs(@Param("record") MlSchedulerTaskInstance record, @Param("example") MlSchedulerTaskInstanceExample example);

    int updateByExample(@Param("record") MlSchedulerTaskInstance record, @Param("example") MlSchedulerTaskInstanceExample example);

    int updateByPrimaryKeySelective(MlSchedulerTaskInstance record);

    int updateByPrimaryKeyWithBLOBs(MlSchedulerTaskInstance record);

    int updateByPrimaryKey(MlSchedulerTaskInstance record);
}