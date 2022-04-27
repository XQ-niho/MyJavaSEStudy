package com.syed.day13_list_set;


import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program: MyJavaSE
 * @description: java.util.Collections, java官方集合工具类
 *
 *  面试题:
 *  Collection和Collections的区别?
 *  Collection是Java集合框架顶级接口之一,Collections是Java集合工具类
 *
 * @author: USER
 * @create: 2022-03-26
 */
public class CollectionsDemo {
    public static void main(String[] args) {
        List<Integer> intList = Lists.newArrayList(6,5,4,7);
        List<String> strList = Lists.newArrayList("AA","BB","CC");

        Car car1 = new Car("Benz", "E300L", 400000.0);
        Car car2 = new Car("Bmw", "320Li", 250000.0);
        Car car3 = new Car("Audi", "Q7", 700000.0);
        Car car4 = new Car("Byd", "汉EV", 250000.0);
        Car car5 = new Car("Cadillac", "XT5", 350000.0);
        List<Car> cars = Lists.newArrayList(car1, car2, car3, car4, car5);
        
        //把集合元素反转
        Collections.reverse(strList);

        //随机打乱集合元素
        Collections.shuffle(intList);

        //定义排序规则
        Collections.sort(cars,(o1,o2) ->o1.getPrice().compareTo(o2.getPrice()));
        //简化写法只适用于从小到大的排序
        Collections.sort(cars, Comparator.comparing(Car::getPrice));

        //多重排序规则，从大到小排序价格，如果价格一致，则排序品牌
        Collections.sort(cars, (o1, o2) -> {
            int result = o2.getPrice().compareTo(o1.getPrice());
            if(result == 0){
                result = o1.getBrand().compareTo(o2.getBrand());
            }
            return result;
        });

        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                int result = o2.getPrice().compareTo(o1.getPrice());
                if(result == 0){
                    result = o1.getBrand().compareTo(o2.getBrand());
                }
                return result;
            }
        });
    }

}
