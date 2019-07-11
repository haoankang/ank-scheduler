package ank.hao.core.model;

import java.io.Serializable;

public class GetArgsParam implements Serializable {

    public static final long serialVersionUID = 11L;

    private String taskName;

    private String queryArgs;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getQueryArgs() {
        return queryArgs;
    }

    public void setQueryArgs(String queryArgs) {
        this.queryArgs = queryArgs;
    }
}
