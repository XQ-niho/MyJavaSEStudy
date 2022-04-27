package com.syed.day21_reflect_annotation;

/**
 * @program: MyJavaSE
 * @description: 自定义注解
 * @author: USER
 * @create: 2022-04-11
 */
//@interface表示注解

//元注解,用来修饰注解的注解

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * * @Target
 * * 指定注解可以使用的位置,如果不指定,则表示可以使用在全局
 * * ElementType枚举:
 *      TYPE,FIELD,METHOD,CONSTRUCTOR...
 *
 * * @Retention
 * * 用来设置注解的保持力,注解持续状态
 * * RetentionPolicy枚举:
 *     SOURCE           枚举值存在于源码中,编译后丢弃
 *     CLASS(默认值)     编译完成后枚举保留在字节码文件中,运行时丢弃
 *     RUNTIME          注解在运行期间仍然保留可以访问,反射可以获取
 */
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    /**
     * 枚举中一般只有属性概念,没有方法概念
     * 属性必须是如下格式: 属性类型 属性名();
     * 属性类型只能是基本类型,字符串,枚举或者以上这些类型的一维数组
     * 属性名默认为value,如果使用默认名称并且只有一个属性时,value可以省略
     * 属性可以设置默认值,如果设置了默认值,则使用时不必要去设置属性的值
     */
    String value() default "";

    int[] nums() default {1,2,3,4};
}
