package ank.hao.scheduler.mapper;

import ank.hao.scheduler.domain.MlSchedulerJob;
import ank.hao.scheduler.domain.MlSchedulerJobExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlSchedulerJobMapper {
    long countByExample(MlSchedulerJobExample example);

    int deleteByExample(MlSchedulerJobExample example);

    int deleteByPrimaryKey(Integer jobId);

    int insert(MlSchedulerJob record);

    int insertSelective(MlSchedulerJob record);

    List<MlSchedulerJob> selectByExampleWithBLOBs(MlSchedulerJobExample example);

    List<MlSchedulerJob> selectByExample(MlSchedulerJobExample example);

    MlSchedulerJob selectByPrimaryKey(Integer jobId);

    int updateByExampleSelective(@Param("record") MlSchedulerJob record, @Param("example") MlSchedulerJobExample example);

    int updateByExampleWithBLOBs(@Param("record") MlSchedulerJob record, @Param("example") MlSchedulerJobExample example);

    int updateByExample(@Param("record") MlSchedulerJob record, @Param("example") MlSchedulerJobExample example);

    int updateByPrimaryKeySelective(MlSchedulerJob record);

    int updateByPrimaryKeyWithBLOBs(MlSchedulerJob record);

    int updateByPrimaryKey(MlSchedulerJob record);
}