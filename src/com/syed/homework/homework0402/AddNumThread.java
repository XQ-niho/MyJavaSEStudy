package com.syed.homework.homework0402;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: MyJavaSE
 * @description: 编写10个线程，第一个从1加到10，第二个从线程从11加到20..
 * 最后把十个线程结果相加
 * @author: USER
 * @create: 2022-04-02
 */
public class AddNumThread {

    static class AddNum implements Callable<Integer> {

        private int startAddNum;

        public AddNum(int startNum) {
            this.startAddNum = startNum;
        }

        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += (startAddNum++);
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            Callable<Integer> addNumThread = new AddNum(10 * i + 1);
            FutureTask<Integer> futureTask = new FutureTask<>(addNumThread);
            Thread thread = new Thread(futureTask, "线程" + (i + 1));
            thread.start();
            try {
                ans += futureTask.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("和：" + ans);
    }

}

