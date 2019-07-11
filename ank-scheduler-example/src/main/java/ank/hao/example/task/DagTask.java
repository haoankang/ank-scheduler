package ank.hao.example.task;

import ank.hao.core.annotation.AnkTask;
import ank.hao.core.log.ExecutorLog;
import ank.hao.core.model.ReturnT;
import ank.hao.core.task.IAnkTask;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

@AnkTask(desc = "DAG任务demo")
public class DagTask implements IAnkTask {

    int stopId = 0;

    @Override
    //任务执行，要求执行结果同步返回
    public ReturnT<String> execute(String param) {
        ExecutorLog.infoLog("调度执行任务，接收任务参数：{}", param);
        stopId = 22;
        try {
            TimeUnit.SECONDS.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ReturnT.SUCCESS;
    }

    @Override
    public void beforeExecute(){
        ExecutorLog.infoLog("调度任务执行前");
    }

    @Override
    public void afterExecute(){
        ExecutorLog.infoLog("调度任务执行后");
    }

    @Override
    public Object getAvaliableParams(String queryArgs) {
        JSONObject args = JSON.parseObject(queryArgs);
        int queryType = args.getIntValue("queryType");
        if(queryType==0){
            JSONArray result = new JSONArray();
            JSONObject res1 = new JSONObject();
            res1.put("projectId","111");
            res1.put("projectName","项目空间1");
            JSONObject res2 = new JSONObject();
            res2.put("projectId","222");
            res2.put("projectName","项目空间2");
            result.add(res1);
            result.add(res2);
            return result;
        }else if(queryType==1) {
            JSONObject params = args.getJSONObject("params");
            String projectId = params.getString("projectId");
            if(!StringUtils.isEmpty(projectId)){
                JSONArray resultArray = new JSONArray();
                JSONObject result = new JSONObject();
                result.put("planId","0c5ddcf9222f4e25b00483db270ffaa1");
                result.put("planName", "hak");
                JSONArray jsonArray = new JSONArray();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("historyId", "7d1f255234d04dbfade5eaff788dea44");
                jsonObject.put("versionName", "1.0");
                jsonArray.add(jsonObject);
                result.put("planVersions",jsonArray);
                resultArray.add(result);
                return resultArray;
            }
        }
        return null;
    }

    @Override
    public void stop() {

    }
}
