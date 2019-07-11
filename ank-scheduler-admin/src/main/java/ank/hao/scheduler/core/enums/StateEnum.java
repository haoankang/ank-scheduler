package ank.hao.scheduler.core.enums;

public enum StateEnum {

    PUBLISH(1, "上线"),
    UNPUBLISH(0, "下线");

    Integer code;
    String msg;
    StateEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
