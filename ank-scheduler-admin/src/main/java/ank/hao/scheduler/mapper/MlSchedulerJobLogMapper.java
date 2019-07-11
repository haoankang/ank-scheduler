package ank.hao.scheduler.mapper;

import ank.hao.scheduler.domain.MlSchedulerJobLog;
import ank.hao.scheduler.domain.MlSchedulerJobLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlSchedulerJobLogMapper {
    long countByExample(MlSchedulerJobLogExample example);

    int deleteByExample(MlSchedulerJobLogExample example);

    int deleteByPrimaryKey(Integer jobLogId);

    int insert(MlSchedulerJobLog record);

    int insertSelective(MlSchedulerJobLog record);

    List<MlSchedulerJobLog> selectByExample(MlSchedulerJobLogExample example);

    MlSchedulerJobLog selectByPrimaryKey(Integer jobLogId);

    int updateByExampleSelective(@Param("record") MlSchedulerJobLog record, @Param("example") MlSchedulerJobLogExample example);

    int updateByExample(@Param("record") MlSchedulerJobLog record, @Param("example") MlSchedulerJobLogExample example);

    int updateByPrimaryKeySelective(MlSchedulerJobLog record);

    int updateByPrimaryKey(MlSchedulerJobLog record);
}