package com.syed.day17_thread.threadcommunication.producerandconsumercase;

/**
 * description：吃货类
 * @author Administrator
 * @date 2022/4/2 11:25
 */
public class ChiHu extends Thread {
    public BaoZi baoZi;



    public ChiHu(BaoZi baoZi) {
        this.baoZi = baoZi;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (baoZi) {
                if (baoZi.flag) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("包子吃完了,赶紧生产吧...");
                    baoZi.flag = false;
                    //唤醒生产者
                    baoZi.notify();
                }
                try {
                    baoZi.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}