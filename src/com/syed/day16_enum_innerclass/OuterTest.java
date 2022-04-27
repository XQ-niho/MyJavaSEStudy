package com.syed.day16_enum_innerclass;

import static com.syed.day16_enum_innerclass.OuterClass.*;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-03-31
 */
public class OuterTest {
    public static void main(String[] args) {
        //成员内部类的创建以及方法调用
        /*Outer.MemberInnerClass mic = new Outer().new MemberInnerClass();
        mic.memberInnerMethod();*/

        //注意: 由于成员内部类的创建方式比较复杂,所以,一般在开发中我们可以把成员内部类设置成private
        //然后提供一个方法来创建成员内部类对象,再调用方法
        new OuterClass().outerMethod();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        //静态内部类测试
        //Outer.StaticInnerClass sic = new Outer.StaticInnerClass();

        //静态内部类可以简化成普通类的创建方式,前提,添加静态导入
        StaticInnerClass sic = new StaticInnerClass();
        sic.staticInnerMethod();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        //测试局部内部类
        new OuterClass().outerMethod2();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        //测试匿名内部类
        new OuterClass().outerMethod3();
    }
}
