package ank.hao.scheduler.core.enums;

public enum DeleteFlagEnum {

    UNDELETE(0, "未删除"),
    DELETED(1, "已删除");

    Integer code;
    String name;

    DeleteFlagEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
