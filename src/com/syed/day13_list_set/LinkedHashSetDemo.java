package com.syed.day13_list_set;

import java.util.LinkedHashSet;

/**
 * @program: MyJavaSE
 * @description: java.util.LinkedHashSet 继承了 java.util.HashSet
 * 特点: 有序(存进去和取出来是一样的顺序)的HashSet
 * @author: USER
 * @create: 2022-03-28
 */
public class LinkedHashSetDemo {
    public static void main(String[] args) {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(30);
        linkedHashSet.add(20);
        linkedHashSet.add(40);
        linkedHashSet.add(10);
        linkedHashSet.add(20);
        linkedHashSet.forEach(System.out::println);
    }
}
