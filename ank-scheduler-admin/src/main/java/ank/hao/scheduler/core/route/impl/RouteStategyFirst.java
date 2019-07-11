package ank.hao.scheduler.core.route.impl;

import ank.hao.scheduler.core.route.IRouteStategy;

import java.util.List;

public class RouteStategyFirst implements IRouteStategy {
    @Override
    public String getRouteAddress(List<String> list) {
        return list.get(0);
    }
}
