package com.syed.day17_thread.threadcommunication;

/**
 * @program: MyJavaSE
 * @description: 写两条线程,
 * 一条线程负责打印A-Z一共26个字母,一条线程负责打印1-52的数字,
 * 要求打印结果必须为如下格式: 12A34B56C78D...5152Z
 * @author: USER
 * @create: 2022-03-31
 */
public class TakeTurnsPrint {
    public static void main(String[] args) {
        Object obj = new Object();
        Thread printNum = new PrintNumberThread(obj);
        Thread printLet = new PrintLetterThread(obj);
        printNum.start();
        printLet.start();
    }
}

class PrintLetterThread extends Thread {

    private final Object obj;

    public PrintLetterThread(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj) {
            for (int i = 0; i < 26; i++) {
                System.out.print((char) ('A' + i));
                obj.notifyAll();
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class PrintNumberThread extends Thread {
    private final Object obj;

    public PrintNumberThread(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj) {
            for (int i = 1; i <= 52; i++) {
                System.out.print(i);
                if (i % 2 == 0) {
                    obj.notifyAll();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
