package com.syed.day17_thread;

/**
 * @program: MyJavaSE
 * @description: 多线程并发特性: 顺序性
 * JVM在执行代码的时候,会对代码的执行顺序进行一定的优化调整,但是前提是
 * 代码逻辑是正确的,不会影响最终的运行结果 -- 指令重排
 * <p>
 * int a = 10;//1
 * int b = 2;//2
 * a = a + 1;//3
 * b = a + a;//4
 * <p>
 * 执行顺序:2134也可能是1324,但是不可能是1423
 * <p>
 * 分析:
 * 如果在单线程环境下,这种重排没有问题,但是多线程环境下,就可能出现问题
 * <p>
 * 例如: 以下情况,B线程开始时在睡眠,当A线程创建完obj对象后,改变init的值,B线程就会打破循环,执行doSomething(obj)方法,这是正确情况
 * 但是JVM有指令重排,如果线程A的代码被指令重排了,就有可能状态改变发生在创建obj对象之前,此时如果状态改了,则B线程就会打破睡眠,然后
 * 执行doSomething(obj),但是此时obj对象还没有创建的话,就会抛异常!!!
 * <p>
 * 解决方式: volatile,它的作用之一就是可以禁止JVM指令重排
 * <p>
 * 线程A:
 * obj = createObj();
 * init = true;
 * <p>
 * 线程B:
 * while(!init){
 * sleep();
 * }
 * doSomething(obj);
 * @author: USER
 * @create: 2022-04-01
 */
public class ThreadCurrentOfVolatile2 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 500000; i++) {
            State state = new State();
            ThreadA threadA = new ThreadA(state);
            ThreadB threadB = new ThreadB(state);
            threadA.start();
            threadB.start();
            threadA.join();
            threadB.join();
        }
    }

    static class ThreadA extends Thread {
        private final ThreadCurrentOfVolatile2.State state;

        public ThreadA(ThreadCurrentOfVolatile2.State state) {
            this.state = state;
        }

        @Override
        public void run() {
            state.a = 1;
            state.b = 1;
            state.c = 1;
            state.d = 1;
        }
    }

    static class ThreadB extends Thread {
        private final ThreadCurrentOfVolatile2.State state;

        public ThreadB(ThreadCurrentOfVolatile2.State state) {
            this.state = state;
        }

        @Override
        public void run() {
            if (state.b == 1 && state.a == 0) {
                System.out.println("b == 1");
            }
            if (state.c == 1 && (state.b == 0 || state.a == 0)) {
                System.out.println("c == 1");
            }
            if (state.d == 1 && (state.a == 0 || state.b == 0)) {
                System.out.println("d == 1");
            }
        }
    }

    static class State {
        // volatile屏蔽JVM指令重排
        public volatile int a = 0;
        public volatile int b = 0;
        public volatile int c = 0;
        public volatile int d = 0;
    }
}
