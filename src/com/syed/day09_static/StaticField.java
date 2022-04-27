package com.syed.day09_static;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/18 14:47
 */
public class StaticField {
    /**
     *
     * 修饰属性 --> 静态属性
     * 普通属性初始化的时机是当调用构造方法创建对象时,如果多次调用构造方法,则普通属性值会重新赋值(重置)
     * 静态属性初始化的时机是类加载的时候,而且只执行一次,即不会重置
     *
     * 应用: 利用静态属性来产生唯一性的自增ID
     */
    /**
     * 普通属性
     */
    private final int id;
    /**
     * 静态属性
     */
    private static int uId;

    public StaticField() {
        this.id = uId++;
    }

    public static void main(String[] args) {
        StaticField s1 = new StaticField();
        StaticField s2 = new StaticField();
        StaticField s3 = new StaticField();

        System.out.println(s1.id);
        System.out.println(s2.id);
        System.out.println(s3.id);
    }

}
