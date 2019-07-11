package ank.hao.scheduler.core.route.impl;

import ank.hao.scheduler.core.route.IRouteStategy;

import java.util.List;

public class RouteStategyLast implements IRouteStategy {
    @Override
    public String getRouteAddress(List<String> list) {
        return list.get(list.size()-1);
    }
}
