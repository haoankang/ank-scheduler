package ank.hao.core.util;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

public class FeignUtil {

    public static Object getFeignClient(Class tClass,String url){

        return Feign.builder().decoder(new GsonDecoder()).target(tClass, url);
    }

    public static Object getFeignClientAddHttp(Class tClass,String url){

        return Feign.builder().encoder(new GsonEncoder()).decoder(new GsonDecoder()).target(tClass, "http://"+url);
    }
}
