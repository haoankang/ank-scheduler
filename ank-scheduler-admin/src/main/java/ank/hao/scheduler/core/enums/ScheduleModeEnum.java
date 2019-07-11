package ank.hao.scheduler.core.enums;

public enum ScheduleModeEnum {
    ONCE(0,"once", "onceScheduler"),
    CRON(1,"cron", "cronScheduler"),
    CHILD(2,"child", "onceScheduler"); //子任务不能直接执行，依赖于父任务

    Integer code;
    String name;
    String schduler;
    ScheduleModeEnum(Integer code, String name, String schduler){
        this.code=code;
        this.name=name;
        this.schduler=schduler;
    }

    public static ScheduleModeEnum getScheduleMode(Integer code){
        for(ScheduleModeEnum scheduleMode: ScheduleModeEnum.values()){
            if(scheduleMode.code==code){
                return scheduleMode;
            }
        }
        return ONCE;
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

    public String getSchduler() {
        return schduler;
    }

    public void setSchduler(String schduler) {
        this.schduler = schduler;
    }
}
