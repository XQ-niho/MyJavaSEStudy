package com.syed.day11_object_string_packageclass;

/**
 * @description: java.lang.Object类getClass()方法
 *                 用来获取类的类实例,类实例有且只有一份，对应的类型是java.lang.Class类
 *
 *                如何获取类的Class实例：
 *                      1、Object的getClass()方法，要求先创建类对象，然后调用getClass()方法
 *                      2、Class类中的静态方法forName(“类的全限定名”)
 *                          如果传入的类名有误，则会抛出异常：java.lang.ClassNotFoundException
 *                          此方法要求强制处理异常
 *                      3、类名.class属性
 *
 *
 * @author: qiu
 * @date: 2022/3/23 9:43
 */
public class ObjectOfGetClass {
    public static void main(String[] args) throws ClassNotFoundException {
        Emp emp = new Emp(89,2,"Jack");
        Emp emp1 = new Emp(34,1,"Tom");

        //1、Object的getClass()方法，要求先创建类对象，然后调用getClass()方法
        Class clazz = emp.getClass();
        Class clazz1 = emp1.getClass();
        System.out.println(clazz == clazz1);

        //2、Class类中的静态方法forName(“类的全限定名”)
        Class clazz2 = Class.forName("com.syed.day11_object_string_packageclass.Emp");
        System.out.println(clazz == clazz2);

        //3、类名.class属性
        Class clazz3 = Emp.class;
        System.out.println(clazz == clazz3);


    }
}
