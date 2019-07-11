package ank.hao.scheduler.domain;

public class MlSchedulerGroup {
    /** 自增id*/
    private Integer id;

    /** 执行器AppName*/
    private String appName;

    /** 执行器名称*/
    private String title;

    /** 执行器地址类型：0=自动注册、1=手动录入*/
    private Integer addressType;

    /** 注册执行器地址列表，多地址逗号分隔*/
    private String addressList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAddressType() {
        return addressType;
    }

    public void setAddressType(Integer addressType) {
        this.addressType = addressType;
    }

    public String getAddressList() {
        return addressList;
    }

    public void setAddressList(String addressList) {
        this.addressList = addressList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appName=").append(appName);
        sb.append(", title=").append(title);
        sb.append(", addressType=").append(addressType);
        sb.append(", addressList=").append(addressList);
        sb.append("]");
        return sb.toString();
    }
}