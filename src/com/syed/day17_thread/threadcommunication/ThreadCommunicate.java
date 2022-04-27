package com.syed.day17_thread.threadcommunication;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: MyJavaSE
 * @description: 线程通信
 *
 * 1.synchronized + wait/notify机制
 * wait(),让当前线程释放对象锁并且进入等待阻塞状态
 * notify()/notifyAll(),唤醒一个/所有正在等待相应对象锁的线程,使其进入可运行状态,以便得到CPU资源的执行
 *
 * 注意:
 * wait(),notify(),notifyAll()方法都是final类型的,无法重写
 * wait(),notify(),notifyAll()方法都是属于Object类的
 *
 *
 * 2.Lock + Condition机制,JDK5.0 JUC -- java.util.concurrent,java并发相关的类都在这个包下
 * 它是用来代替传统的wait()/notify()方式
 * 	await()                     等待
 * 	signal()/signalAll()        唤醒
 *
 *
 * 面试题
 * 1.为什么线程通信方法不属于Thread类而属于Object类?
 * 因为线程通信一定是有同步的,即synchronized锁定的就是Object对象(锁可以是任意对象),通信方法其实是基于锁的.
 *
 * 2.wait()方法和sleep()的区别?
 * wait(),释放锁
 * sleep(),不释放锁
 * @author: USER
 * @create: 2022-04-02
 */
public class ThreadCommunicate {

    private volatile List<String> list = new ArrayList<>();

    public void add() {
        list.add("abc");
    }

    public int size() {
        return list.size();
    }
}

class Thread1 extends Thread {
    private ThreadCommunicate threadCommunicate;

    public Thread1(ThreadCommunicate threadCommunicate, String name) {
        super(name);
        this.threadCommunicate = threadCommunicate;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                threadCommunicate.add();
                System.out.println("添加了" + (i + 1) + "个元素.");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread2 extends Thread {
    private ThreadCommunicate threadCommunicate;

    public Thread2(ThreadCommunicate threadCommunicate, String name) {
        super(name);
        this.threadCommunicate = threadCommunicate;
    }

    @Override
    public void run() {
        try {
            while(true){
                if(threadCommunicate.size() == 2){
                    System.out.println("容量==2了,线程2退出...");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Test{
    public static void main(String[] args) {
        ThreadCommunicate tc = new ThreadCommunicate();
        Thread1 t1 = new Thread1(tc,"线程1");
        Thread2 t2 = new Thread2(tc,"线程2");
        t1.start();
        t2.start();
    }
}
