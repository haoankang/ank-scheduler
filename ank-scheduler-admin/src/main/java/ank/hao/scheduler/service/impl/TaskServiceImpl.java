package ank.hao.scheduler.service.impl;


import ank.hao.core.model.GetArgsParam;
import ank.hao.core.model.ReturnT;
import ank.hao.core.util.FeignUtil;
import ank.hao.scheduler.core.component.BaseService;
import ank.hao.scheduler.core.enums.RouteStategyEnum;
import ank.hao.scheduler.core.feign.ExecutorFeign;
import ank.hao.scheduler.service.TaskService;
import org.springframework.stereotype.Component;

@Component
public class TaskServiceImpl extends BaseService implements TaskService {
    @Override
    public Object taskParams(String appName, String taskName, String queryArgs) {
        //获取feign
        String url = routeUrl(appName, RouteStategyEnum.ROUTE_TYPE_RANDOM.getCode());
        ExecutorFeign executorFeign = (ExecutorFeign) FeignUtil.getFeignClientAddHttp(ExecutorFeign.class, url);
        //组装参数
        GetArgsParam getArgsParam = new GetArgsParam();
        getArgsParam.setTaskName(taskName);
        getArgsParam.setQueryArgs(queryArgs);
        ReturnT returnT = executorFeign.getExecutorParams(getArgsParam);
        if(returnT.getCode()==200){
            return returnT.getContent();
        }else{
            return null;
        }
    }
}