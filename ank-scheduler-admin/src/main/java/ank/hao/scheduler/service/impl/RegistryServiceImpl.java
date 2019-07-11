package ank.hao.scheduler.service.impl;

import ank.hao.core.model.CallBackParam;
import ank.hao.scheduler.core.component.BaseService;
import ank.hao.scheduler.core.thread.CallBackThread;
import ank.hao.scheduler.core.thread.SchedulerThreadPool;
import ank.hao.scheduler.domain.*;
import ank.hao.scheduler.core.enums.RegistryTypeEnum;
import ank.hao.scheduler.service.RegistryService;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class RegistryServiceImpl extends BaseService implements RegistryService {

    @Override
    public String registryExecutor(String body) {
        JSONObject registryExecutorParam = JSON.parseObject(body);
        String executorName = registryExecutorParam.getString("executorName");
        String executorAddress = registryExecutorParam.getString("executorAddress");

        //检查是否已经有了对应的注册器
        MlSchedulerGroupExample mlSchedulerGroupExample = new MlSchedulerGroupExample();
        mlSchedulerGroupExample.createCriteria().andAppNameEqualTo(executorName);
        List<MlSchedulerGroup> mlSchedulerGroupList = mlSchedulerGroupMapper.selectByExample(mlSchedulerGroupExample);
        //编码逻辑保证APP_NAME唯一
        MlSchedulerGroup mlSchedulerGroup;
        if(CollectionUtils.isEmpty(mlSchedulerGroupList)){
            mlSchedulerGroup = new MlSchedulerGroup();
            mlSchedulerGroup.setAppName(executorName);
            mlSchedulerGroup.setTitle(executorName);
            //暂时不做排序功能
            mlSchedulerGroup.setAddressType(RegistryTypeEnum.AUTO.getCode());
            mlSchedulerGroup.setAddressList(executorAddress);
            mlSchedulerGroupMapper.insertSelective(mlSchedulerGroup);
        }else {
            mlSchedulerGroup = mlSchedulerGroupList.get(0);
            String addressList = mlSchedulerGroup.getAddressList()==null?"":mlSchedulerGroup.getAddressList();
            //校验此ip是否已注册
            List<String> checkIPList = Arrays.asList(addressList.split(","));
            if(!checkIPList.contains(executorAddress)){
                StringBuilder addressList_new = new StringBuilder();
                addressList_new.append(addressList);
                if(!StringUtils.isEmpty(addressList)){
                    addressList_new.append(",");
                }
                addressList_new.append(executorAddress);
                mlSchedulerGroup.setAddressList(addressList_new.toString());
                mlSchedulerGroupMapper.updateByPrimaryKeySelective(mlSchedulerGroup);
            }
        }
        //检查更新group_detail表
        MlSchedulerGroupDetailExample mlSchedulerGroupDetailExample = new MlSchedulerGroupDetailExample();
        mlSchedulerGroupDetailExample.createCriteria().andAppNameEqualTo(executorName).andAddressEqualTo(executorAddress);
        List<MlSchedulerGroupDetail> mlSchedulerGroupDetailList = mlSchedulerGroupDetailMapper.selectByExample(mlSchedulerGroupDetailExample);
        if(CollectionUtils.isEmpty(mlSchedulerGroupDetailList)){
            MlSchedulerGroupDetail mlSchedulerGroupDetail = new MlSchedulerGroupDetail();
            mlSchedulerGroupDetail.setAppName(executorName);
            mlSchedulerGroupDetail.setAddress(executorAddress);
            mlSchedulerGroupDetailMapper.insert(mlSchedulerGroupDetail);
        }

        return "SUCCESS";
    }

    @Override
    public String registryService(String registryServiceParam) {

        JSONObject jsonObject = JSON.parseObject(registryServiceParam);
        String executorName = jsonObject.getString("executorName");
        String taskName = jsonObject.getString("taskName");
        String taskDesc = jsonObject.getString("taskDesc");

        //判断服务是否已存在
        MlSchedulerTaskExample mlSchedulerTaskExample = new MlSchedulerTaskExample();
        mlSchedulerTaskExample.createCriteria().andTaskNameEqualTo(taskName).andAppNameEqualTo(executorName);
        List<MlSchedulerTask> mlSchedulerTasks = mlSchedulerTaskMapper.selectByExample(mlSchedulerTaskExample);
        MlSchedulerTask mlSchedulerTask;
        if(CollectionUtils.isEmpty(mlSchedulerTasks)){
            //代码逻辑保证TASK_NAME+APP_NAME唯一
            mlSchedulerTask = new MlSchedulerTask();
            mlSchedulerTask.setTaskName(taskName);
            mlSchedulerTask.setAppName(executorName);
            mlSchedulerTask.setTaskDesc(taskDesc);
            mlSchedulerTask.setTaskSource(RegistryTypeEnum.AUTO.getCode());
            mlSchedulerTask.setCreateTime(new Date());
            mlSchedulerTask.setUpdateTime(new Date());
            mlSchedulerTaskMapper.insert(mlSchedulerTask);
        }
        return "SUCCESS";
    }

    @Override
    public String executorCallback(CallBackParam callBackParam) {
        SchedulerThreadPool.TASK_CALLBACK_THREAD_POOL.execute(new CallBackThread(callBackParam));
        return "SUCCESS";
    }
}
