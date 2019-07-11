package ank.hao.core.task;

import ank.hao.core.model.ReturnT;

//适合需要关闭的任务
@Deprecated
public interface IAnkTaskNeedStop extends IAnkTask {

    /**
     * 返回任务停止时需要的stopId
     * @param param param一般是json字符串
     * @return
     */
    ReturnT<String> execute(String param);

    //任务执行完成，报告执行结果
    ReturnT reportResult();

    //停止接口
    void stop(String stopId);

}
