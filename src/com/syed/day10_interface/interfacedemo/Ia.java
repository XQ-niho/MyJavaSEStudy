package com.syed.day10_interface.interfacedemo;

/**
 * @description: 接口定义
 * JDK8.0开始，接口提供了多个新的特性
 *       a.接口中可以默认实现的普通方法，必须使用default来定义
 *       b.接口中支持静态方法
 *
 * 3.接口是用来被类实现的,关键字implements,实现就类似于继承关系
 *   一个类如果实现了接口,则必须重写这个接口中所有的抽象方法,除非这个类是抽象类
 * 注意: 类和类之间是继承,类和接口之间是实现,接口和接口之间也是继承
 * 4.一个类只能直接继承另一个类
 *   一个类可以实现多个接口,多个接口之间用,隔开,当然也要求重写这些接口中所有的抽象方法
 * 5.接口之间可以实现多重继承,即一个接口可以同时继承多个接口
 * @author: qiu
 * @date: 2022/3/21 13:51
 */
public interface Ia extends Ib,Ic{
    /**
     * 属性：公开的静态常量属性
     * 注意：属性可以简写省略public static final
     *
     */
    int RECT = 1;
    int CIRCLE = 2;

    /**
     * 接口中没有构造方法，不能实例化对象
     */
    /*public Ia(){

    }*/

    /**
     * 接口中不能有普通方法
     * 注意：方法可以简写，省略public abstract
     */

    void method();

    /**
     * JDK8.0新特性默认方法
     */
    default void method2(){
        System.out.println();
    }

    /**
     * JDK8.0新特性静态方法
     */
    public static void method3(){
        System.out.println();
    }
}
