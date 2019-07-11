package ank.hao.example.task;

import ank.hao.core.annotation.AnkTask;
import ank.hao.core.model.ReturnT;
import ank.hao.core.task.IAnkTask;
import ank.hao.core.task.IAnkTaskNeedStop;
import ank.hao.example.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;

@AnkTask(desc = "to be stop.")
public class ToStopTask implements IAnkTask {

    @Autowired
    private DemoService demoService;

    private String param;

    @Override
    public ReturnT<String> execute(String param) {
        this.param = param;
        demoService.execute();
        return new ReturnT<>(200, "success", "stopId-1122");
    }

    @Override
    public void stop() {

    }
}
