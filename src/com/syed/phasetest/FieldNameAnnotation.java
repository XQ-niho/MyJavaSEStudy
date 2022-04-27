package com.syed.phasetest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: MyJavaSEStudy
 * @description:
 * @author: USER
 * @create: 2022-04-21
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldNameAnnotation {
    String fieldName();
}
