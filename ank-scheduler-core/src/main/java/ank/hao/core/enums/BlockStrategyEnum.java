package ank.hao.core.enums;

//阻塞策略
public enum BlockStrategyEnum {

    SERIAL(0, "串行执行"),
    PARALLEL(1, "并行执行"),
    DISCARD_LATER(2, "丢弃后来任务"),
    COVER_EARLY(3, "覆盖上个任务");

    private Integer code;
    private String desc;

    BlockStrategyEnum(Integer code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
