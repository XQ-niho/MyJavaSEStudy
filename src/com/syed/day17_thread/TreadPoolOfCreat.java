package com.syed.day17_thread;

import java.util.concurrent.*;

/**
 * @program: MyJavaSE
 * @description: 线程池創建方式一
 * @author: USER
 * @create: 2022-04-01
 */
public class TreadPoolOfCreat {
    public static void main(String[] args) {
        /**
         *  方式一:
         *  public ThreadPoolExecutor(
         *  int corePoolSize,           核心线程数
         *  int maximumPoolSize,        最大线程数       PS:非核心线程数=最大线程数-核心线程数
         *  long keepAliveTime,         最大存活时间
         *  TimeUnit unit,              存活时间的单位
         *  BlockingQueue<Runnable> workQueue,  缓冲队列(等待队列)
         *          ArrayBlockingQueue          有限数组队列,它可以设置队列的长度
         *          LinkedBlockingQueue         无限链表队列
         *          SynchronousQueue            无容量队列
         *          PriorityBlockingQueue       无限优先级队列
         *
         *  ThreadFactory threadFactory,        忽略(非必须)
         *  RejectedExecutionHandler handler    拒绝策略,当最大线程容量和队列都满时,多出的线程任务如何处理
         *          AbortPolicy (默认值)         直接丢弃,会抛出异常: RejectedExecutionException
         *          CallerRunsPolicy            交给调用方的线程来运行
         *          DiscardPolicy               抛弃当前的请求(任务),不抛出异常
         *          DiscardOldestPolicy         抛弃队列中最旧的请求(任务),自己加入到队列中,但是不抛出异常
         *  ) {}
         */
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                2,
                4,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(15),
                new ThreadPoolExecutor.AbortPolicy()
        );

        /**
         * 方式二: 使用工具类来创建线程池对象
         * 注意: 工具类的创建各种线程池的方式本质上还是使用了第一种方式,只不过参数都帮你设置好了
         */
        /**
         *  定长的线程池对象,可以提供固定的线程数来运行任务,多出来的任务将等待...
         *  new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
         *  定长的线程池，有核心线程，核心线程的即为最大的线程数量，没有非核心线程,队列无界,存活时间无意义,拒绝策略无意义...
         */
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

        /**
         * 缓冲线程池
         * new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
         * 无核心线程,最大线程容量为2147483647,即非核心线程数,存活时间60秒,队列为无容量队列
         */
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        /**
         * 单一线程的线程池: 只有一条线程来执行任务，适用于有顺序的任务的应用场景
         * new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>()))
         * 一个核心线程,没有非核心线程,存活时间无意义,队列无界
         */
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        /**
         * 周期性执行任务的线程池
         * 按照某种特定的计划执行线程中的任务，有核心线程，但也有非核心线程，非核心线程的大小也为无限大。适用于执行周期性的任务
         */
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
    }

}
