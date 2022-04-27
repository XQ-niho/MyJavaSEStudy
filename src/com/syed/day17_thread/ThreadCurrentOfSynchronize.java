package com.syed.day17_thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: MyJavaSE
 * @description: 多线程并发:原子性
 * @author: USER
 * @create: 2022-04-01
 */
public class ThreadCurrentOfSynchronize {
    private static int count = 0;

    //创建一个锁对象(synchronized方式)
    //private static Object obj = new Object();

    //JDK5.0提供的并发相关的类
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    /**
                     * 本质上三步:
                     * 1.读取count的值
                     * 2.++
                     * 3.写回计算后的count值
                     *
                     * 线程是把主内存中的count值读取到线程内存中进行操作的,计算完成后还要把线程内存中的数据写回主内存,
                     * 所以在多线程并发环境下,如果没有保证原子性,就有可能出现多个线程同时操作这个count变量,造成数据不一致的情况.
                     *
                     * 如何保证原子性?
                     * 加锁
                     * 方式一.synchronized
                     * 1.把synchronized加载方法上,缺点:加锁范围可能过大,性能损耗较多,而且不能灵活添加读个锁标记
                     * 2.通过synchronized代码块来进行加锁,好处就是可以减少加锁的范围,性能损耗较少,并且可以指定多个锁标记
                     *
                     * synchronized的原理:
                     *
                     * 方式二:Lock对象
                     * 通过编码来指定锁的范围,在任何位置通过代码来加锁和解锁
                     * a.创建Lock对象 :  private static Lock lock = new ReentrantLock();
                     * b.通过该对象进行加锁和解锁
                     *
                     * 对比两种加锁方式?
                     * 并发量较少时,两者没有太大差别;并发量非常大时,Lock的性能远远高于synchronized,而且Lock还提供了更多的功能.
                     */
                    //synchronized (SynchronizedDemo.class) {
                   /* synchronized (obj) {
                        count++;
                    }*/

                    try {
                        lock.lock();//加锁
                        count++;
                    } finally {
                        //finally代码的特点是上面代码无论是否出现异常,finally中的代码始终会被执行!
                        lock.unlock();//解锁
                    }
                }
            });
            t.start();
        }
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
