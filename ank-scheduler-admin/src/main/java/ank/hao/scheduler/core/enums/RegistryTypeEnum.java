package ank.hao.scheduler.core.enums;

public enum RegistryTypeEnum {

    AUTO(0, "自动注册"),
    MANUAL(1, "手动录入");

    private Integer code;
    private String msg;

    RegistryTypeEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
