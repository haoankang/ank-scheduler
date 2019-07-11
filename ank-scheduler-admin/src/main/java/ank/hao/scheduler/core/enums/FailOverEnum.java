package ank.hao.scheduler.core.enums;

public enum FailOverEnum {

    DO_NOTHING(0, "忽略继续执行"),
    RETRY(1, "失败重试"),
    FAIL_FULL(2, "作业结束");

    private int code;
    private String message;

    FailOverEnum(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
