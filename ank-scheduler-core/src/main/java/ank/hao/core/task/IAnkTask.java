package ank.hao.core.task;

import ank.hao.core.model.ReturnT;

import java.util.List;

//一般任务，适合短期的、或不需要关闭的任务类型
public interface IAnkTask {

    /**
     * 同步返回执行状态和结果
     * @param param param一般是json字符串
     * @return
     */
    ReturnT execute(String param);

    //扩展，执行任务前执行逻辑
    default void beforeExecute(){}

    //扩展，执行任务后执行逻辑
    default void afterExecute(){}

    //扩展，获取任务可用参数列表
    default Object getAvaliableParams(String queryArgs){return null;}

    //扩展，停止任务接口
    default void stop(){}
}
