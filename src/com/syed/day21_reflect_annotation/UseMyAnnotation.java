package com.syed.day21_reflect_annotation;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-04-11
 */
@MyAnnotation
public class UseMyAnnotation {

    @MyAnnotation
    private int myField;

    //@AnnotationOfCreat
    public UseMyAnnotation() {
    }

    //@AnnotationOfCreat(value = "abc")
    //@AnnotationOfCreat("abc")
    @MyAnnotation(value = "abc", nums = {10, 20, 30})
    public void method() {

    }

    public static void main(String[] args) {
        /**
         * 获取注解，以及获取注解中的属性 -- 原理：反射技术
         */
        try {
            //1、获取类的Class实例
            Class useMyAnnotationClass = UseMyAnnotation.class;
            //获取类注解
            MyAnnotation classAnnotation = (MyAnnotation) useMyAnnotationClass.getAnnotation(MyAnnotation.class);
            //2、获取method方法
            Method methodAnnotation = useMyAnnotationClass.getMethod("method");
            //3.从方法上拿到注解
            //注意: 注解持久力必须设置为RUNTIME才可以反射获取
            MyAnnotation annotation = methodAnnotation.getAnnotation(MyAnnotation.class);
            //4.从注解对象中获取属性值
            System.out.println(annotation.value());
            System.out.println(Arrays.toString(annotation.nums()));
            //TODO...
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

}
