package com.syed.day17_thread;

/**
 * @program: MyJavaSE
 * @description: 多线程并发特性：可见性
 *
 * 问题:
 * 当main主线程修改了共享变量flag后,线程1却没有停止.
 *
 * 分析:
 * 当前程序中存在两个线程,分别是main线程和线程1线程,这两个线程都会把flag这个变量的副本读取到自己的线程内存中,
 * 然后就进行后续操作,当其中一个线程改变了这个flag变量后,并没有把flag最新的结果写回到主内存中,所以另一个线程
 * 对其的改变时不见的,所以线程1以为flag还是false,自然结束不了
 *
 * 如何解决?
 * 在共享变量上添加关键字:volatile
 *
 * volatile关键字的作用之一: 可以使线程内存中的数据的改变立马被其他线程可以读取
 * @author: USER
 * @create: 2022-04-01
 */
public class ThreadCurrentOfVolatile {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        new Thread(t, "线程1").start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.setFlag(true);
        System.out.println(Thread.currentThread().getName() + "已停止运行...");
    }
}

class MyThread implements Runnable {

    public volatile boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
        System.out.println(Thread.currentThread().getName() + "的flag已经修改为:" + this.flag);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始运行...");
        while (true) {
            if (flag) {
                System.out.println(Thread.currentThread().getName() + "停止运行...");
                Thread.currentThread().stop();
            }
        }
    }
}
