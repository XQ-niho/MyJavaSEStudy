package com.syed.homework.test1;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/20 21:06
 */
public class Test1 {
    public static void main(String[] args) {
        //下边这组大括号非常重要
        List<String> list = new ArrayList<String>() {};
        System.out.println(getActualType(list,0));
    }

    public static String getActualType(Object o,int index) {
        Type clazz = o.getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType)clazz;
        return pt.getActualTypeArguments()[index].toString();
    }
}
