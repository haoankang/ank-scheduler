package ank.hao.scheduler.mapper;

import ank.hao.scheduler.domain.MlSchedulerTask;
import ank.hao.scheduler.domain.MlSchedulerTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlSchedulerTaskMapper {
    long countByExample(MlSchedulerTaskExample example);

    int deleteByExample(MlSchedulerTaskExample example);

    int deleteByPrimaryKey(Integer taskId);

    int insert(MlSchedulerTask record);

    int insertSelective(MlSchedulerTask record);

    List<MlSchedulerTask> selectByExample(MlSchedulerTaskExample example);

    MlSchedulerTask selectByPrimaryKey(Integer taskId);

    int updateByExampleSelective(@Param("record") MlSchedulerTask record, @Param("example") MlSchedulerTaskExample example);

    int updateByExample(@Param("record") MlSchedulerTask record, @Param("example") MlSchedulerTaskExample example);

    int updateByPrimaryKeySelective(MlSchedulerTask record);

    int updateByPrimaryKey(MlSchedulerTask record);
}