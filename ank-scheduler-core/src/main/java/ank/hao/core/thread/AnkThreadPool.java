package ank.hao.core.thread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AnkThreadPool {

    //任务执行线程池
    public static final ThreadPoolExecutor taskRunThreadPool = new ThreadPoolExecutor(10, 100, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(1000), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "ank-scheduler, core-AnkThreadPool-taskRunThreadPool-"+r.hashCode());
        }
    });

    //任务运行监测线程池
//    public static final ThreadPoolExecutor taskMonitorThreadPool = new ThreadPoolExecutor(10, 200, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(1000), new ThreadFactory() {
//        @Override
//        public Thread newThread(Runnable r) {
//            return new Thread(r, "ank-scheduler, core-AnkThreadPool-taskMonitorThreadPool-"+r.hashCode());
//        }
//    });
}
