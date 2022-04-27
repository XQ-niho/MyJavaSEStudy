package com.syed.day17_thread.threadcommunication;

import java.util.LinkedList;

/**
 * description：生产者消费者模式
 * @author Administrator
 * @date 2022/4/2 10:33
 */
public class ProducerAndConsumerOfSynchronizedWaitNotify {
    private final int EMPTY = 10;

    private final int FULL = 0;

    private LinkedList<Integer> list = new LinkedList<>();

    class Producer extends Thread {
        @Override
        public void run() {
            producer();
        }

        private void producer() {
            while (true) {
                synchronized (list) {
                    while (list.size() == EMPTY) {
                        list.notify();
                        System.out.println("当前队列满!");
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    list.add(1);
                    list.notify();
                    System.out.println("生产者生产了一个任务,当前任务列表的长度为:" + list.size());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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
                synchronized (list) {
                    while (list.size() == FULL) {
                        list.notify();
                        System.out.println("当前任务列表为空!");
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    list.poll();
                    list.notify();
                    System.out.println("消费者消费了一条任务,当前任务列表的长度为: " + list.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerAndConsumerOfSynchronizedWaitNotify pc = new ProducerAndConsumerOfSynchronizedWaitNotify();
        Producer producer = pc.new Producer();
        Consumer consumer = pc.new Consumer();
        producer.start();
        consumer.start();
    }
}