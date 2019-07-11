package ank.hao.scheduler.mapper;

import ank.hao.scheduler.domain.MlSchedulerTaskInstanceLog;
import ank.hao.scheduler.domain.MlSchedulerTaskInstanceLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlSchedulerTaskInstanceLogMapper {
    long countByExample(MlSchedulerTaskInstanceLogExample example);

    int deleteByExample(MlSchedulerTaskInstanceLogExample example);

    int deleteByPrimaryKey(Integer taskInstanceLogId);

    int insert(MlSchedulerTaskInstanceLog record);

    int insertSelective(MlSchedulerTaskInstanceLog record);

    List<MlSchedulerTaskInstanceLog> selectByExample(MlSchedulerTaskInstanceLogExample example);

    MlSchedulerTaskInstanceLog selectByPrimaryKey(Integer taskInstanceLogId);

    int updateByExampleSelective(@Param("record") MlSchedulerTaskInstanceLog record, @Param("example") MlSchedulerTaskInstanceLogExample example);

    int updateByExample(@Param("record") MlSchedulerTaskInstanceLog record, @Param("example") MlSchedulerTaskInstanceLogExample example);

    int updateByPrimaryKeySelective(MlSchedulerTaskInstanceLog record);

    int updateByPrimaryKey(MlSchedulerTaskInstanceLog record);
}