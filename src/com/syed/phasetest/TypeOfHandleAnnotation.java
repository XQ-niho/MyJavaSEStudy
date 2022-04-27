package com.syed.phasetest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: MyJavaSEStudy
 * @description: 解析策略注解
 * @author: USER
 * @create: 2022-04-20
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TypeOfHandleAnnotation {
    AnalysisStrategy strategy() default AnalysisStrategy.ANALYSIS_ALL;
    int dealNum() default -1;
}
