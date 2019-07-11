package ank.hao.scheduler.core.enums;

public enum HandleStateEnum {

    RUNNING(0, "运行中"),
    SUCCESS(1, "成功"),
    FAIL(2, "失败"),
    TO_RUN(3, "待运行");


    Integer code;
    String name;

    HandleStateEnum(Integer code, String name){
        this.code=code;
        this.name=name;
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
