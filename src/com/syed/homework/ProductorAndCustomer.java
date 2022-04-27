package com.syed.homework;

import java.util.LinkedList;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-04-02
 */
public class ProductorAndCustomer {

    private final int EMPTY = 10;
    private final int FULL = 0;

    private LinkedList<Integer> linkedList = new LinkedList<>();

    class Producer extends Thread {
        @Override
        public void run() {
            producer();
        }

        private void producer() {
            while (true) {
                synchronized (linkedList) {
                    while (linkedList.size() == EMPTY) {
                        System.out.println("队列已满");
                        linkedList.notify();
                        try {
                            linkedList.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    linkedList.add(1);
                    System.out.println("生产者生产了一个任务,当前队列有" + linkedList.size());
                    linkedList.notify();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class Customer extends Thread {
        @Override
        public void run() {
            customer();
        }

        private void customer() {
            while (true) {
                synchronized (linkedList) {
                    while (linkedList.size() == FULL) {
                        linkedList.notify();
                        try {
                            linkedList.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    linkedList.poll();
                    System.out.println("消费者消了一个任务,当前队列有" + linkedList.size());
                    linkedList.notify();
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
        ProductorAndCustomer pc = new ProductorAndCustomer();
        Producer producer = pc.new Producer();
        Customer customer = pc.new Customer();
        producer.start();
        customer.start();
    }
}
