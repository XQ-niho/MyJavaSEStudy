package com.syed.day21_reflect_annotation;

import java.lang.reflect.Array;

/**
 * @program: MyJavaSE
 * @description: 反射操作数组
 * <p>
 * java.lang.reflect.Array  表示数组的反射类
 * <p>
 * 面试题:
 * Array和Arrays的区别?
 * @author: USER
 * @create: 2022-04-11
 */
public class ArrayReflect {
    public static void main(String[] args) {
        //反射创建数组
        int[] intArr = (int[]) Array.newInstance(int.class, 3);
        //反射创建多维数组
        //String[][] strArr = (String[][]) Array.newInstance(String.class, 5, 5);

        //反射通过下标设置数组元素
        Array.set(intArr,0,1);
        Array.set(intArr,1,2);
        Array.set(intArr,2,3);

        printArray(intArr);
    }

    /**
     * 反射操作数组
     * 写一个方法遍历数组
     */
    public static void printArray(Object arr){
        //反射获取数组长度
        int length = Array.getLength(arr);

        for(int i = 0; i < length; i++){
            //反射通过下标获取数组元素
            Object o = Array.get(arr, i);
            System.out.println(o);
        }
    }
}
