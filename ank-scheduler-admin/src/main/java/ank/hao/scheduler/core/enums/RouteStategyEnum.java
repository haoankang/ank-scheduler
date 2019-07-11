package ank.hao.scheduler.core.enums;

import ank.hao.scheduler.core.route.IRouteStategy;
import ank.hao.scheduler.core.route.impl.RouteStategyFirst;
import ank.hao.scheduler.core.route.impl.RouteStategyLast;
import ank.hao.scheduler.core.route.impl.RouteStategyRandom;

public enum RouteStategyEnum {

    ROUTE_TYPE_FIRST(0, "第一个", new RouteStategyFirst()),
    ROUTE_TYPE_RANDOM(1, "随机选取", new RouteStategyRandom()),
    ROUTE_TYPE_LAST(2,"最后一个", new RouteStategyLast());

    private int code;
    private String message;
    private IRouteStategy routeStategy;

    RouteStategyEnum(int code, String message, IRouteStategy routeStategy){
        this.code = code;
        this.message = message;
        this.routeStategy = routeStategy;
    }

    public static RouteStategyEnum getRouteStategy(int code){
        switch (code){
            case 0:
                return ROUTE_TYPE_FIRST;
            case 2:
                return ROUTE_TYPE_LAST;
            default:
                return ROUTE_TYPE_RANDOM;
        }
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public IRouteStategy getRouteStategy() {
        return routeStategy;
    }
}
