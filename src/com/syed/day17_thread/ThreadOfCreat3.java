package com.syed.day17_thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: MyJavaSE
 * @description: java创建线程的方式三
 * 写一个类实现java.util.current.Callable接口，并且重写call()方法
 *
 * @author: USER
 * @create: 2022-03-31
 */
public class ThreadOfCreat3 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        //TODO...
        return 1;
    }
}

class TestThreadDemo3{
    public static void main(String[] args) {
        Callable<Integer> c = new ThreadOfCreat3();
        //FutureTask包装了Callable类并且间接继承了Runnable
        FutureTask<Integer> futureTask = new FutureTask<>(c);
        //启动线程
        Thread t = new Thread(futureTask);
        t.start();

        //获取线程方法执行后返回信息 get()
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}