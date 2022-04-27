package com.syed.day14_map_generic;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: MyJavaSE
 * @description: 泛型通配:指定泛型范围
 *
 * 通配符：?
 *
 * 搭配使用；
 * 通配上限 ? extends 类型
 * 通配下限 ? super 类型
 * @author: USER
 * @create: 2022-03-29
 */
public class GenericWildcard {
    public static void main(String[] args) {
        List<Integer> integerList = Lists.newArrayList(2, 5, 6, 7, 9);
        List<Long> longList = Lists.newArrayList(10L, 3L, 5L);
        printList(longList);
        printList(integerList);

        //注意: 通配符一般不单用,即不要这么定义,这种集合只能添加null元素
        List<?> list = new ArrayList<>();
        //list.add(10);
        //list.add("");
        //list.add(true);
        list.add(null);

    }

    /**
     * 打印不同类型的集合
     * 泛型通配指定上限
     *
     * @param list
     */
    public static void printList(List<? extends Number> list) {
        list.forEach(System.out::println);
    }
}
