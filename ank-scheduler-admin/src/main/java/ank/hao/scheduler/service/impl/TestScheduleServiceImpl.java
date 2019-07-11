package ank.hao.scheduler.service.impl;

import ank.hao.core.model.ExecutorParam;
import ank.hao.core.util.FeignUtil;
import ank.hao.scheduler.core.component.BaseService;
import ank.hao.scheduler.domain.MlSchedulerGroupDetail;
import ank.hao.scheduler.domain.MlSchedulerGroupDetailExample;
import ank.hao.scheduler.domain.MlSchedulerTask;
import ank.hao.scheduler.domain.MlSchedulerTaskExample;
import ank.hao.scheduler.core.feign.ExecutorFeign;
import ank.hao.scheduler.service.TestScheduleService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestScheduleServiceImpl extends BaseService implements TestScheduleService {

    @Override
    public void test() {
        List<MlSchedulerTask> mlSchedulerTaskList = mlSchedulerTaskMapper.selectByExample(new MlSchedulerTaskExample());
        for(MlSchedulerTask mlSchedulerTask: mlSchedulerTaskList){
            MlSchedulerGroupDetailExample mlSchedulerGroupDetailExample = new MlSchedulerGroupDetailExample();
            mlSchedulerGroupDetailExample.createCriteria().andAppNameEqualTo(mlSchedulerTask.getAppName());
            List<MlSchedulerGroupDetail> mlSchedulerGroupDetails = mlSchedulerGroupDetailMapper.selectByExample(mlSchedulerGroupDetailExample);
            String url = mlSchedulerGroupDetails.get(0).getAddress();
            ExecutorFeign executorFeign = (ExecutorFeign) FeignUtil.getFeignClientAddHttp(ExecutorFeign.class, url);
            ExecutorParam executorParam = new ExecutorParam();
            executorParam.setTaskName(mlSchedulerTask.getTaskName());
            JSONObject taskParam = new JSONObject();
            taskParam.put("param1", "aaa");
            taskParam.put("param2", "bbb");
            executorParam.setTaskParam(taskParam.toJSONString());
            executorFeign.executorService(executorParam);
        }
    }
}
