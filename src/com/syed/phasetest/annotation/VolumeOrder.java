package com.syed.phasetest.annotation;

import com.syed.phasetest.constans.Order;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: MyJavaSEStudy
 * @description:
 * @author: USER
 * @create: 2022-04-29
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface VolumeOrder {
    Order orderType() default Order.ASC;
}
