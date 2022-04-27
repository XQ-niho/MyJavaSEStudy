package com.syed.day17_thread.threadcommunication.producerandconsumercase;

/**
 * description：包子铺
 * @author Administrator
 * @date 2022/4/2 11:20
 */
public class BaoZiPu extends Thread {

    public BaoZi baoZi;

    public BaoZiPu(BaoZi baoZi) {
        this.baoZi = baoZi;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (baoZi){
                if(baoZi.flag){
                    //暂停生产
                    try {
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count++;
                if(count % 2 == 0){
                    baoZi.pi = "冰皮";
                    baoZi.xian = "豆沙";
                }else{
                    baoZi.pi="薄皮";
                    baoZi.xian="肉";
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                baoZi.flag = true;
                //唤醒线程,呼叫吃货来吃包子
                baoZi.notify();
                System.out.println(baoZi.pi + baoZi.xian + ",生产好了,可以来吃了...");
            }
        }
    }
}