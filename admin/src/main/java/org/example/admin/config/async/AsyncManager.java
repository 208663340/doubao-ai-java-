package org.example.admin.config.async;


import org.example.admin.utils.spring.SpringUtils;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * 异步任务管理器
 *
 * @Author: Administrator
 **/
public class AsyncManager {
    private static AsyncManager me = new AsyncManager();
    /**
     * 操作延迟10毫秒
     */
   // private final int OPERATE_DELAY_TIME = 10;
    /**
     * 立即执行
     */
  //  private final int OPERATE_IMMEDIATELY_TIME = 0;
    /**
     * 异步操作任务调度线程池
     */
   // private ScheduledExecutorService executor = SpringUtils.getBean("scheduledExecutorService");
    private SimpleAsyncTaskExecutor asyncTaskExecutor = SpringUtils.getBean("asyncTask");

    /**
     * 单例模式
     */
    private AsyncManager() {
    }

    public static AsyncManager me() {
        return me;
    }

    /**
     * 执行任务
     *
     * @param task 任务
     */
/*    public void execute(TimerTask task) {
        executor.schedule(task, OPERATE_DELAY_TIME, TimeUnit.MILLISECONDS);
    }*/

    /**
     * 执行任务并获取返回值
     *
     * @param task 任务
     * @param <T>  任务参数类型
     * @return 任务返回值
     */
/*    public <T> Future<T> execute(Callable<T> task) {
        return executor.schedule(task, OPERATE_DELAY_TIME, TimeUnit.MILLISECONDS);
    }*/

    /**
     * 异步执行任务
     *
     * @param task 任务
     * @param <T>  任务参数类型
     * @return 任务返回值
     */
    public <T> Future<T> asyncExecute(Callable<T> task) {
        return asyncTaskExecutor.submit(task);
    }

    /**
     * 停止任务线程池
     */
/*    public void shutdown() {
        Threads.shutdownAndAwaitTermination(executor);
    }*/
}
