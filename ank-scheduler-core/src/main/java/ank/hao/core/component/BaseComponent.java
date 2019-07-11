package ank.hao.core.component;

import ank.hao.core.feign.SchedulerFeign;
import ank.hao.core.log.ExecutorLog;
import ank.hao.core.util.FeignUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Random;

@Component
public class BaseComponent implements InitializingBean {

    private static BaseComponent baseComponent;

    public static BaseComponent getBaseComponent(){
        return baseComponent;
    }

    //可用调度中心地址列表
    private List<String> addressList;

    public SchedulerFeign getSchedulerFeign() {

        if(CollectionUtils.isEmpty(addressList)){
            ExecutorLog.errorLog("无可用的调度中心！！请检查！");
            return null;
        }
        //随机选取调度中心
        String url = addressList.get(new Random().nextInt(addressList.size()));
        return (SchedulerFeign) FeignUtil.getFeignClient(SchedulerFeign.class, url);
    }

    public List<String> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<String> addressList) {
        this.addressList = addressList;
    }

    @Override
    public void afterPropertiesSet() {
        baseComponent = this;
    }
}
