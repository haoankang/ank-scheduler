package ank.hao.scheduler.mapper;

import ank.hao.scheduler.domain.MlSchedulerGroupDetail;
import ank.hao.scheduler.domain.MlSchedulerGroupDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlSchedulerGroupDetailMapper {
    long countByExample(MlSchedulerGroupDetailExample example);

    int deleteByExample(MlSchedulerGroupDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MlSchedulerGroupDetail record);

    int insertSelective(MlSchedulerGroupDetail record);

    List<MlSchedulerGroupDetail> selectByExample(MlSchedulerGroupDetailExample example);

    MlSchedulerGroupDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MlSchedulerGroupDetail record, @Param("example") MlSchedulerGroupDetailExample example);

    int updateByExample(@Param("record") MlSchedulerGroupDetail record, @Param("example") MlSchedulerGroupDetailExample example);

    int updateByPrimaryKeySelective(MlSchedulerGroupDetail record);

    int updateByPrimaryKey(MlSchedulerGroupDetail record);
}