package com.syed.day17_thread;

/**
 * @program: MyJavaSE
 * @description: java创建多线程的方式之一
 * <p>
 * 写一个类实现java.lang.Runnable接口，并且重写run()方法
 * @author: USER
 * @create: 2022-03-31
 */
public class ThreadOfCreat2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class TestThreadDemo2 {
    public static void main(String[] args) {
        //创建Runnable实例
        Runnable r = new ThreadOfCreat2();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        //匿名创建线程
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                //TODO...
            }
        }).start();*/

        //JDK8.0升级为Lambda表达式
       /* new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();*/
    }
}
