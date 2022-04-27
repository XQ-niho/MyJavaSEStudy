package com.syed.day17_thread;

/**
 * @program: MyJavaSE
 * @description: java实多线程的方式一：
 * 写一个类，继承java.lang.Thread类并且重写run()方法
 * @author: USER
 * @create: 2022-03-31
 */
public class ThreadOfCreat1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + ":" + i);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class TestThreadDemo1 {
    public static void main(String[] args) {
        //创建线程
        Thread t1 = new ThreadOfCreat1();
        Thread t2 = new ThreadOfCreat1();

        //启动线程
        t1.start();
        t2.start();

        //匿名方式创建线程
        /*new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(getName() + " : " + i);
                    try {
                        //线程睡眠
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();*/
    }
}