package com.syed.day17_thread;

/**
 * @program: MyJavaSE
 * @description: java线程常用方法
 * @author: USER
 * @create: 2022-03-31
 */
public class ThreadOfMethod {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                /**
                 * currentThread(),用来获取当前正在执行的线程
                 * getName(),获取线程的名称
                 * getId(),获取线程的id
                 */
                System.out.println(Thread.currentThread().getId() + "-" + Thread.currentThread().getName() + ":" + i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "线程1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getId() + "-" + Thread.currentThread().getName() + ":" + i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "线程2");

        /**
         * 获取线程状态
         * 1.线程通过new创建              初始态             BEGINNING
         *
         * 2.调用start()启动线程          可运行态            RUNNABLE
         *
         * 3.得到CPU资源                  运行态             RUNNING
         *      正在运行的线程调用了暂停方法yield()方法,则进入可运行状态
         *
         * 4.调用join(),sleep()...       阻塞态             BLOCKING
         *      ==> join()线程执行结束/sleep睡眠时间结束,则阻塞态会打破,线程会回到RUNNABLE状态!!!
         *      注意:线程由于某些情况暂停后想要恢复,必须先经过可运行状态,当获取到CPU时,然后才能真正恢复到运行态
         *
         * 5.线程执行完毕                 终止态             TERMINATE
         *
         * 特殊状态
         * 6.调用wait()                  等待队列           WAITING_QUEUE     线程通信相关
         *      注意: 等待队列状态的线程调用notify或者notifyAll方法或者wait超时都会进入锁池状态
         *
         * 7.多线程并发同步锁synchronized  锁池态             LOCKING
         *      当锁标记被释放,则会进入到可运行状态
         */
        System.out.println(t1.getState());

        /**
         * setName(name),设置线程名字
         * 注意: 除了set方法可以设置线程名字之外,还可以通过构造方法来设置线程名字
         */
        //t1.setName("线程1");
        //t2.setName("线程2");

        /**
         * getPriority()        获取线程的优先级
         * setPriority(int)     设置线程的优先级
         *
         * 注意:
         * 线程创建后优先级默认为5,我们可以通过setPriority()来设置,设置范围为1~10,
         * 1为最低优先级,10位最高优先级
         * 优先级对应的常量
         * Thread.MIN_PRIORITY          1
         * Thread.NORM_PRIORITY         5
         * Thread.MAX_PRIORITY          10
         *
         * 线程优先级可以从一定的程度上影响线程执行的先后顺序,但是不能完全保证执行的顺序!
         * 不能通过设置线程优先级来完全控制线程执行的先后顺序,要完全控制线程谁先运行,谁后运行需要通过线程通信技术来解决!!!
         */
        //System.out.println(t1.getPriority());
        //t1.setPriority(1);
        //t1.setPriority(Thread.MIN_PRIORITY);
        //t2.setPriority(Thread.MAX_PRIORITY);

        /**
         * 设置线程为守护线程
         * 守护线程是指伴随其他线程一起执行的线程,它的特点是,如果其他线程运行结束了,则守护线程也会自动结束,即使还没有完全运行完成
         *
         * 注意:
         * 设置守护线程必须在线程启动之前设置,否则会抛出异常:java.lang.IllegalThreadStateException
         *
         * 补充:
         * GC就是一个守护线程,它是伴随着JVM的启动而启动,JVM的退出而退出的,守护JVM的资源回收
         */
        t2.setDaemon(true);
        //System.out.println(t2.isDaemon());//判断是否是守护线程

        /**
         * start()
         * 启动线程的方法
         * 注意: start()方法表示线程启动,它的本质是呼叫JVM调用了run()方法
         * run()方法不是给我们去调用的,是JVM调用的
         */
        t1.start();
        t2.start();
    }
}
