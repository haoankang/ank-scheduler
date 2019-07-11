package ank.hao.scheduler.core.route.impl;

import ank.hao.scheduler.core.route.IRouteStategy;

import java.util.List;
import java.util.Random;

public class RouteStategyRandom implements IRouteStategy {
    @Override
    public String getRouteAddress(List<String> list) {
        return list.get(new Random().nextInt(list.size()));
    }
}
