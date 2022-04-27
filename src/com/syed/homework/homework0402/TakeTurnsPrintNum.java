package com.syed.homework.homework0402;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: MyJavaSE
 * @description: 两个线程轮流打印数字，一直到100
 * @author: USER
 * @create: 2022-04-02
 */
public class TakeTurnsPrintNum {

    private static final int MAX_LIMIT = 100;
    private int num = 0;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    class PrintNumberThread implements Runnable {
        @Override
        public void run() {
            try {
                lock.lock();
                while (num <= MAX_LIMIT) {
                    System.out.println(Thread.currentThread().getName() + "打印：" + (num++));
                    condition.signal();
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        TakeTurnsPrintNum ttp = new TakeTurnsPrintNum();
        Runnable pnt = ttp.new PrintNumberThread();
        Thread t1 = new Thread(pnt,"线程1");
        Thread t2 = new Thread(pnt,"线程2");
        t1.start();
        t2.start();
    }
}


