package ank.hao.scheduler.core.thread;

import ank.hao.scheduler.core.component.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public class JobRunDaemonThread implements Runnable {
    @Override
    public void run() {
        while (true){
            try {
                //获取要执行的作业列表
                List<Integer> taskToRunList = BaseService.getBaseService().getMlSchedulerExtMapper().taskToRunList();
                if(!CollectionUtils.isEmpty(taskToRunList)){
                    for(Integer taskToRunId:taskToRunList){
                        SchedulerThreadPool.JOB_RUN_THREAD_POOL.execute(new JobRunThread(taskToRunId));
                    }
                }

                //检查任务是否超时以及运行状态
                //TODO

                TimeUnit.SECONDS.sleep(10);
            }catch (Exception e){
                log.error("作业运行线程出错，{}", e.getMessage());
            }
        }
    }
}
