package com.syed.day14_map_generic;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * @program: MyJavaSE
 * @description: java.util.Map 是双列集合，即存放的是元素键值对的形式
 *
 * 特点：
 * key无序不可重复 value可重复
 * 如果添加的元素key相同，则后一次的key和value会覆盖前一次
 *
 * Map实现类：
 * HashMap, HashTable
 *
 * Map的作用: 分门别类管理数据,通过map集合来按照指定的规则进行数据分类,然后供后续操作使用
 *
 * 注意: HashSet其实本质上就是一个特殊的HashMap,特殊在它的value为null
 *
 * @author: USER
 * @create: 2022-03-29
 */
public class MapOfCreat {
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        Map<String, Integer> map1 = new Hashtable<>();

        map.put('A',4);
        map.put('B',1);
        map.put('C',3);
        map.put('D',2);
        map.put('E',5);

        System.out.println(map);

        Set<Character> strings = map.keySet();
        strings.forEach(System.out::println);

    }
}
