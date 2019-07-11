package ank.hao.scheduler.mapper;

import ank.hao.scheduler.domain.MlSchedulerGroup;
import ank.hao.scheduler.domain.MlSchedulerGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlSchedulerGroupMapper {
    long countByExample(MlSchedulerGroupExample example);

    int deleteByExample(MlSchedulerGroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MlSchedulerGroup record);

    int insertSelective(MlSchedulerGroup record);

    List<MlSchedulerGroup> selectByExample(MlSchedulerGroupExample example);

    MlSchedulerGroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MlSchedulerGroup record, @Param("example") MlSchedulerGroupExample example);

    int updateByExample(@Param("record") MlSchedulerGroup record, @Param("example") MlSchedulerGroupExample example);

    int updateByPrimaryKeySelective(MlSchedulerGroup record);

    int updateByPrimaryKey(MlSchedulerGroup record);
}