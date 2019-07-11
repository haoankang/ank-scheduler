package ank.hao.scheduler.core.thread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SchedulerThreadPool {

    public static final ThreadPoolExecutor JOB_RUN_THREAD_POOL = new ThreadPoolExecutor(10, 200, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(1000), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "ank-scheduler, admin-SchedulerThreadPool-JOB_RUN_THREAD_POOL-"+r.hashCode());
        }
    });

    public static final ThreadPoolExecutor TASK_CALLBACK_THREAD_POOL = new ThreadPoolExecutor(10, 200, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(1000), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "ank-scheduler, admin-SchedulerThreadPool-TASK_CALLBACK_THREAD_POOL-"+r.hashCode());
        }
    });
}
