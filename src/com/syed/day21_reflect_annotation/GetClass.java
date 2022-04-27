package com.syed.day21_reflect_annotation;

import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * description：
 * Object类getClass()方法,获取当前类的类实例,它是反射的起始步骤
 *
 * @author Administrator
 * @date 2022/4/8 16:40
 */
public class GetClass {
    public static void main(String[] args) {
        //1.Object的getClass()方法
        Class c1 = new Point().getClass();
        //2.Class.forName()方法
        Class c2 = null;
        try {
            c2 = Class.forName("com.syedu.day18.Point");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //3.类名.class
        Class c3 = Point.class;

        System.out.println(c1 == c2);
        System.out.println(c2 == c3);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        //获取包名
        System.out.println(c1.getPackage().getName());
        //System.out.println(c1.getPackageName());
        //获取类名
        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());
        //获取父类
        System.out.println(c1.getSuperclass().getName());
        //获取类实现的接口
        System.out.println(Arrays.toString(c1.getInterfaces()));

        //获取修饰符,修饰符在系统中都是以2的n次方的数字保存的,所以如果要看到修饰符字符串,则需要转换
        System.out.println(Modifier.toString(c1.getModifiers()));
    }
}