package com.syed.homework.homework0402;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-04-02
 */
public class ThreeThreadRun {

    private int count = 0;

    private final Lock lock = new ReentrantLock();
    private final Condition condition1 = lock.newCondition();
    private final Condition condition2 = lock.newCondition();
    private final Condition condition3 = lock.newCondition();

    Thread printNumber = new Thread(() -> {
        try{
            lock.lock();
            for (int i = 1; i <= 26; i++) {
                while (count % 3 != 0){
                    try {
                        condition1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(i * 2 - 1);
                System.out.print(i * 2);
                count++;
                condition2.signal();
            }
        }finally {
            lock.unlock();
        }

    });

    Thread printUpperLetter = new Thread(()->{
        try{
            lock.lock();
            for(char c = 'A'; c <= 'Z'; c++){
                while (count % 3 != 1){
                    try {
                        condition2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(c);
                count++;
                condition3.signal();
            }
        }finally {
            lock.unlock();
        }

    });

    Thread printLowLetter = new Thread(()->{
        try{
            lock.lock();
            for(char c = 'a'; c <='z'; c++){
                while (count % 3 != 2){
                    try {
                        condition3.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(c);
                count++;
                condition1.signal();
            }
        }finally {
            lock.unlock();
        }

    });

    public static void main(String[] args) {
        ThreeThreadRun ttr = new ThreeThreadRun();
        ttr.printNumber.start();
        ttr.printUpperLetter.start();
        ttr.printLowLetter.start();
    }
}
