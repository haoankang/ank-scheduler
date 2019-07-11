package ank.hao.core.task;

import ank.hao.core.model.ReturnT;

//一般任务，适合不需要关闭的任务
@Deprecated
public interface IAnkTaskNoNeedStop extends IAnkTask{

    /**
     * 同步返回执行状态和结果
     * @param param param一般是json字符串
     * @return
     */
    ReturnT execute(String param);
}
