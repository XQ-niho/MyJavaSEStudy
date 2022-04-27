package com.syed.day17_thread;

/**
 * @program: MyJavaSE
 * @description: 多线程单例模式
 *
 * 1、双重验证锁版本(synchronized,dcl,volatile...)
 * 2.静态内部类版本
 *      利用了静态内部类的特性来实现单例模式,相比于DCL版本,它没有synchronized锁,所以性能是比较卓越的
 * 3.单例顶级版本:枚举方式
 *
 *
 * @author: USER
 * @create: 2022-04-02
 */
public class SingletonThreadOfDCL {
    private volatile static SingletonThreadOfDCL demo = null;

    private SingletonThreadOfDCL(){

    }

    /**
     * 多线程环境下,此方法可能出现并发安全问题
     * 通过synchronized来实现并发转换成串行的操作,但是此方式性能较低
     * 所以我们使用synchronized代码块方式来加锁,减少同步代码非范围,
     * 注意:这种方式下需要使用DCL(Double-Check Locking,双重验证锁机制)来确保多线程环境下的真正的单例
     *
     * 分析:
     * 第一次判断为非空判断,如果多个线程都进行了非空判断,则会只有一个线程可以进入同步代码块执行,等它执行完毕后,
     * 锁释放,则另外的线程就会进去执行,如果此时没有第二个非空判断的话,则它们仍然会创建出新对象,单例就失败了!
     */

//    public synchronized static SingletonThreadDemo getInstance(){
    public static SingletonThreadOfDCL getInstance(){
        //第一次校验
        if(demo == null){
            synchronized(SingletonThreadOfDCL.class){
                //第二次校验
                if(demo == null){
                    demo = new SingletonThreadOfDCL();
                }
            }
        }
        return demo;
    }
}
