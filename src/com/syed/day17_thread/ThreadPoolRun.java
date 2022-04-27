package com.syed.day17_thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: MyJavaSE
 * @description: 线程池运行原理
 * @author: USER
 * @create: 2022-04-01
 */
public class ThreadPoolRun {
    public static void main(String[] args) {
        // 核心线程数,最大线程数,保持存活的时间,时间单位,任务队列,饱和策略
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 0; i < 20; i++) {
            try {
                executor.execute(new MyRunnable("第" + (i + 1) + "号线程"));
            } catch (Throwable e) {
                e.printStackTrace();
                System.out.println("丢弃任务: " + (i + 1));
            }
        }
    }

    static class MyRunnable implements Runnable {
        private String name;

        public MyRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name);
            while (true) {
                // 让线程一直执行...
            }
        }
    }
}
