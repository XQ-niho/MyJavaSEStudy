package com.syed.day17_thread.threadcommunication.producerandconsumercase;

/**
 * description：
 * @author Administrator
 * @date 2022/4/2 11:27
 */
public class TestBaoZi {
    public static void main(String[] args) {
        BaoZi baoZi = new BaoZi();
        Thread t1 = new BaoZiPu(baoZi);
        Thread t2 = new ChiHu(baoZi);
        t1.start();
        t2.start();
    }
}