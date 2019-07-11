package ank.hao.core.model;

import java.io.Serializable;

public class CallBackParam implements Serializable {

    public static final long serialVersionUID = 21L;

    private Integer taskInstanceLogId;

    private ReturnT returnT;

    public Integer getTaskInstanceLogId() {
        return taskInstanceLogId;
    }

    public void setTaskInstanceLogId(Integer taskInstanceLogId) {
        this.taskInstanceLogId = taskInstanceLogId;
    }

    public ReturnT getReturnT() {
        return returnT;
    }

    public void setReturnT(ReturnT returnT) {
        this.returnT = returnT;
    }
}
