package com.syed.day13_list_set;

import cn.hutool.core.collection.CollectionUtil;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: MyJavaSE
 * @description: java.util.ArrayList
 * 它的底层原理是数组
 * 它是Collection顶级接口下面的子接口List的实现类
 * <p>
 * 特点:有序(存进去和取出来是一样的顺序),可重复,查询效率高(下标快速定位),增删效率低(增删需要另外建立新数组,还要元素拷贝)
 * <p>
 * ArrayList和Vector
 * 相同点: 功能几乎一致
 * 不同点: ArrayList是线程不安全的,但是性能较高
 * Vector是线程安全的,但是性能相对较低
 * @author: USER
 * @create: 2022-03-25
 */
public class ArrayListOfCreat {
    public static void main(String[] args) {
        /**创建集合容器*/
        //构造一个初始容量为10的空集合
        ArrayList arrayList = new ArrayList();

        //构造一个自定义初始容量的空集合
        ArrayList arrayList1 = new ArrayList(20);

        /**
         *  此集合可以存放任何类型的元素,所以存在类型安全问题,
         *  所以JDK5.0加入了泛型机制,它的其中一个作用就是用来约束集合数据类型
         *  注意:泛型必须是对象类型,不能是基本类型
         */
        //JDK5.0之前
        List list = new ArrayList();
        //JEK5.0之后
        List<Integer> list1 = new ArrayList<Integer>();

        //JDK7.0之后
        //注意:因为泛型不存在多态性,前后一定是一致的,所以,后半部分可以省略,但是<>要保留
        List<Integer> list2 = new ArrayList<>();

        /**创建集合的同时直接赋值*/
        /**
         * 1.JDK9.0之前
         * 本质是:把数组转换成集合
         * 注意: 此方式创建的集合是不可变的,即只读,如果去操作,则抛出异常:
         * java.lang.UnsupportedOperationException
         */
        List<Integer> list3 = Arrays.asList(3,4,5,6);

        /**
         * 2.JDK9.0开始支持
         * 注意: 此方式创建的集合是不可变的,即只读,如果去操作,则抛出异常:
         * java.lang.UnsupportedOperationException
         */
       // List<Integer> list4 = List.of(5,5,6,7);

        /**
         * 3.第三方API来实现
         * 注意:hutool和guava创建出来的集合可以同时直接赋值,而且集合是可以继续操作的
         */
        //hutool
        ArrayList<Integer> intList = CollectionUtil.newArrayList(4,5,6,7);
        intList.add(8);
        System.out.println(intList);

        //Google Guava
        List<String> stringList = Lists.newArrayList("AA","BB","CC");

    }
}
