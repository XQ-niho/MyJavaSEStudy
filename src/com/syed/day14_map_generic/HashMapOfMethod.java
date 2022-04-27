package com.syed.day14_map_generic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: MyJavaSE
 * @description: java.util.HashMap常用方法
 * @author: USER
 * @create: 2022-03-29
 */
public class HashMapOfMethod {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        //添加元素
        map.put(18, "two");
        map.put(1, "one");
        map.put(106, "three");
        map.put(200, "four");

        /**常用方法*/
        //1、判断map中是否包含指定的key和value
        System.out.println(map.containsKey(1));
        System.out.println(map.containsValue("one"));

        //2、根据key获取value
        String value = map.get(3);
        System.out.println(value);

        //3、根据key删除value(key和value都会山粗)
        //map.remove(4);

        //4、把map中所有的value放入到集合中
        Collection<String> values = map.values();
        System.out.println(values);

        /**遍历方法*/
        //1、直接打印
        System.out.println(map);

        //2、forEach
        map.forEach((k, v) -> System.out.println(k + "," + v));

        //3、map专属迭代方式之一：keySet(),把map集合中所有的key放入到Set集合中
        Set<Integer> keys = map.keySet();
        //遍历Set集合中得到Map中每一个key
        for (Integer key : keys) {
            String v = map.get(key);
            System.out.println(key + "," + v);
        }

        //4、map专属迭代方式之二：entrySet(),把map集合中所有的key和value的键值对
        //整体封装成Map.Entry对象(内置的类),并且放入到Set集合中
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        //遍历Set集合，得到每个Entry对象
        for (Map.Entry<Integer, String> entry : entries) {
            Integer k = entry.getKey();
            String v = entry.getValue();
            System.out.println(k + "," + v);
        }


    }
}
