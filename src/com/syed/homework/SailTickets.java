package com.syed.homework;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-04-01
 */
public class SailTickets {
    public static void main(String[] args) {
        Runnable customer = new SailTicketThread();
        Thread t1 = new Thread(customer, "顾客1");
        Thread t2 = new Thread(customer, "顾客2");
        Thread t3 = new Thread(customer, "顾客3");
        t1.start();
        t2.start();
        t3.start();

    }
}

class SailTicketThread implements Runnable {
    private int tickets = 100;
    private static final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "买到第" + tickets + "票");
                    tickets--;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("已售完");
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
