package ank.hao.example.task;

import ank.hao.core.annotation.AnkTask;
import ank.hao.core.model.ReturnT;
import ank.hao.core.task.IAnkTask;
import ank.hao.core.task.IAnkTaskNoNeedStop;
import com.alibaba.fastjson.JSONObject;

@AnkTask(desc = "简单的测试任务")
public class SimpleTask implements IAnkTask {
    public ReturnT<String> execute(String param) {
        return ReturnT.FAIL;
    }

    @Override
    public Object getAvaliableParams(String queryArgs) {
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("aa", "aaaaaaaaa");
        jsonObject1.put("bb", 222222222);
        jsonObject.put("data",jsonObject1);
        jsonObject.put("code",200);
        jsonObject.put("msg","success");
        return jsonObject;
    }
}
