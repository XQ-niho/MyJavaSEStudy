package com.syed.day09_static;

/**
 * @description: static 修饰属性--静态属性的应用之一：
 * java23种设计模式之一：单例模式
 * 保证某个类的实例在JVM中有且只有一份，无论创建多少次对象
 * 优点: 减小系统内存的开销
 * @author: qiu
 * @date: 2022/3/18 15:54
 */
public class SingletonDemo {

    /**
     * 提供静态属性返回当前对象实例
     */
//    private static SingletonDemo  singletonDemo = new SingletonDemo();饿汉模式(积极创建)
    private static SingletonDemo singletonDemo;//懒汉模式(延时创建)

    private SingletonDemo() {
    }

    /**
     * 提供一个公开静态方法，返回当前对象唯一实例
     */
//    public static SingletonDemo getInstace(){
//        return singletonDemo;
//    }

    public static SingletonDemo getInstance(){
        if(null == singletonDemo){
            singletonDemo = new SingletonDemo();
        }
        return singletonDemo;
    }
}
