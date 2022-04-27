package com.syed.day13_list_set;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @program: MyJavaSE
 * @description: java.util.ArrayList中常用方法
 * @author: USER
 * @create: 2022-03-26
 */
public class ArrayListOfMethod {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        /**1、添加方法*/
        //末尾添加元素,有序可重复
        list.add(10);
        list.add(20);
        list.add(10);

        //在指定下标添加
        list.add(1, 50);

        //一次性添加多个元素，参数一表示在哪个下标出添加，如果不给，默认末尾添加
        //list.addAll(List.of(1,2,3));
        list.addAll(Arrays.asList(1, 2, 3));

        /** 2、清空集合元素*/
        list.clear();

        /** 4、判断集合中指定元素首次/最后一次出现的下标，如果不存在则返回-1*/
        int indexOf = list.indexOf(10);
        int lastIndexOf = list.lastIndexOf(10);
        System.out.println(indexOf);
        System.out.println(lastIndexOf);

        /**5、判断集合是否为空*/
        boolean empty = list.isEmpty();

        /**6、删除方法*/
        //a、根据元素下标删除元素，返回删除的元素
        Integer remove = list.remove(0);

        //b、根据元素删除集合元素，返回是否删除成功
        //注意：只能删除首次出现的改元素
        boolean remove1 = list.remove(Integer.valueOf(10));

        //c、删除集合中所有指定的元素，包括重复
        // boolean removeAll = list.removeAll(List.of(10,50,20));
        boolean removeAll = list.removeAll(Arrays.asList(10, 20, 50));

        //d、根据条件删除集合元素
        Car car1 = new Car("奔驰", "E300L", 400000.0);
        Car car2 = new Car("宝马", "320Li", 300000.0);
        List<Car> cars = Lists.newArrayList(car1, car2);
        boolean removeIf1 = cars.removeIf(new Predicate<Car>() {
            @Override
            public boolean test(Car car) {
                return car.getPrice() > 300000.0;
            }
        });
        //lambda表达式写法
        boolean removeIf = cars.removeIf(car -> car.getPrice() > 300000.0);

        /** 7、获取集合元素个数*/
        int size = list.size();

        /** 8、截取子集合*/
        List<Integer> integerList = list.subList(1, 3);

        /**集合遍历*/
        //集合特有的迭代方式
        //1、JDK8.0--forEach
        //list.forEach(x -> System.out.println(x));
        list.forEach(System.out::println);

        //2、迭代器
        //a、获取集合迭代器
        Iterator<Integer> iterator = list.iterator();
        //b、循环迭代
        while (iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println(next);
        }

        //3、直接打印
        System.out.println(list);

        //4、普通for循环
        for(Integer i : list){
        }

    }
}

@Data
@AllArgsConstructor
class Car {
    private String brand;
    private String type;
    private Double price;
}
