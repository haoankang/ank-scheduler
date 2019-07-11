package ank.hao.core;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;
import java.util.concurrent.*;

public class Demo {

    @Test
    public void test() throws UnknownHostException {
//        for(Map.Entry<String,String> entry:System.getenv().entrySet()){
//            System.out.println(entry.getKey()+"---"+entry.getValue());
//        }
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr.getHostAddress());
    }

    @Test
    public void test1() {
        Map<String,String> map = new HashMap<String, String>();
        for(Map.Entry entry: map.entrySet()){
            System.out.println("dksjg");
            System.out.println(entry.getKey());
        }
    }

    @Test
    public void test2(){
        String str = "";
        List<String> list = Arrays.asList(str.split(","));
        System.out.println(list.contains(str));
    }

    @Test
    public void test3(){
        String str = "sdd";
        System.out.println(str.split(",").length);
    }

    @Test
    public void test4() throws InterruptedException, ExecutionException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(100));
        Future<?> future = threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("begin");
                try {
                    TimeUnit.SECONDS.sleep(5L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end");
            }
        });

        while (true){
            System.out.println(future.get());
            TimeUnit.SECONDS.sleep(1L);
        }
    }

    @Test
    public void test5() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(100));
        Future<?> future = threadPoolExecutor.submit(new Callable<String>() {
            @Override
            public String call() {
                System.out.println("begin");
                try {
                    TimeUnit.SECONDS.sleep(5L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end");
                return "end";
            }
        });

        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true){
                        System.out.println("=====");
                        System.out.println(future.get());
                        TimeUnit.SECONDS.sleep(1L);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });

        while (true){
            System.out.println("dsgds");
            TimeUnit.SECONDS.sleep(1L);
        }
    }

    @Test
    public void test6(){
        for(int i=0;i<20;i++){
            System.out.println(new Random().nextInt(3));
        }

    }

    @Test
    public void test7(){
        try {
            int i=3/1;
            String ss = null;
            ss.length();
        } catch (ArithmeticException | NullPointerException ee){
            System.out.println("aa");
        } catch (Exception e){
            System.out.println("bb");
        }
    }

    @Test
    public void test8(){
        int mm = 33;
        switch (mm){
            case 1:
                System.out.println("1");break;
            case 3:
                System.out.println("3");break;
            case 5:
                System.out.println("5");break;
            default:
                System.out.println("99");return;
        }
        System.out.println("do something");
    }

    @Test
    public void test9(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("abcde");
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        System.out.println(stringBuilder.toString());
    }
}
