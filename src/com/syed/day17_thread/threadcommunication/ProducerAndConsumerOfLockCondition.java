package com.syed.day17_thread.threadcommunication;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-04-02
 */
public class ProducerAndConsumerOfLockCondition {
    private final int EMPTY = 10;
    private final int FULL = 0;
    private LinkedList<Integer> list = new LinkedList<>();

    //注意:此处可以创建多个锁标记,然后产生对应的Condition对象,从而提高灵活性
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    class Producer extends Thread {
        @Override
        public void run() {
            producer();
        }

        private void producer() {
            while (true) {
                lock.lock();
                try {
                    while (list.size() == EMPTY) {
                        System.out.println("当前队列满!");
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    list.add(1);
                    condition.signal();
                    System.out.println("生产者生产了一个任务,当前任务列表的长度为:" + list.size());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            consumer();
        }

        private void consumer() {
            while (true) {
                lock.lock();
                try {
                    while (list.size() == FULL) {
                        System.out.println("当前任务列表为空!");
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    list.poll();
                    condition.signal();
                    System.out.println("消费者消费了一条任务,当前任务列表的长度为: " + list.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerAndConsumerOfLockCondition pc = new ProducerAndConsumerOfLockCondition();
        Producer producer = pc.new Producer();
        Consumer consumer = pc.new Consumer();
        producer.start();
        consumer.start();
    }
}
