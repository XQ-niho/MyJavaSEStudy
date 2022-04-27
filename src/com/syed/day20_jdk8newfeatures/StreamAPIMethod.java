package com.syed.day20_jdk8newfeatures;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-04-08
 */
public class StreamAPIMethod {
    public static void main(String[] args) {
        /**
         * 把集合中每个数字计算平方(操作数字)
         */
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5);

        /**
         *  1.map方法,可以对Stream中每个对象进行处理
         *  2.toList方法把Stream转换成集合对象
         */
        //
        //处理链: 先把集合转换成流式对象,通过map进行每个元素的计算,最后打印
        //list.stream().map(e -> e * e).forEach(System.out::println);

        //处理链: 先把集合转换成流式对象,通过map进行每个元素的计算,然后把流式对象转换回集合
        //注意: map的操作可以是多样的
        List<Integer> newList = list.stream().map(e -> e + 1).map(e -> e * e).collect(Collectors.toList());
        System.out.println(newList);

        /**
         * 操作字符串
         */
        Lists.newArrayList("AA", "BB", "CC", "DD").stream().map(s -> s.toLowerCase()).collect(Collectors.toList()).forEach(System.out::println);
        Lists.newArrayList("AA", "BB", "CC", "DD").stream().map(String::toLowerCase).collect(Collectors.toList()).forEach(System.out::println);

        /**
         * 操作对象
         */
        Product p1 = new Product("AA", LocalDate.of(2022, 4, 8), 1000.0);
        Product p2 = new Product("BB", LocalDate.of(2022, 4, 2), 1500.0);
        Product p3 = new Product("CC", LocalDate.of(2022, 4, 7), 1200.0);
        List<Product> products = Lists.newArrayList(p1, p2, p3);
        //List<Product> newProducts = products.stream().map(...)).toList();
        //newProducts.forEach(System.out::println);
        /**
         * filter()方法
         */
        products
                .stream()
                .filter(product ->
                        product.getCreateDate().isAfter(LocalDate.of(2022, 4, 5)))
                .forEach(System.out::println);

        /**
         * reduce()方法，聚合
         */
        Integer reduce = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8).stream().reduce(1, (n1, n2) -> n1 * n2);
        System.out.println(reduce);


        /**
         * 聚合map集合
         */
        List<String> infos = Lists.newArrayList("admin:123456", "admin2:1234567", "admin3:654321");
        /*Map<String, String> reduceMap = infos.stream().map(kv -> {
            String[] split = kv.split(":");
            return Map.of(split[0], split[1]);
        }).reduce(new HashMap<>(), (mp, kv) -> {
            mp.putAll(kv);
            return mp;
        });
        reduceMap.forEach((k, v) -> System.out.println(k + "," + v));*/

        //toMap
        Map<String, String> map = infos.stream()
                .collect(Collectors.toMap(
                        s -> s.split(":")[0],
                        s -> s.split(":")[1]));
        map.forEach((k, v) -> System.out.println(k + "," + v));

        /**
         * distinct()排重,skip()跳过当前前n个元素,limit()截取,sorted()排序
         */
        Car car1 = new Car("Benz", "E300L", 400000.0);
        Car car2 = new Car("Bmw", "320Li", 250000.0);
        Car car3 = new Car("Audi", "Q7", 700000.0);
        Car car4 = new Car("Byd", "汉EV", 250000.0);
        Car car11 = new Car("Byd", "汉EV", 250000.0);
        Car car5 = new Car("Benz", "C200L", 250000.0);
        Car car6 = new Car("Audi", "A4L", 300000.0);
        Car car7 = new Car("Bmw", "M3", 800000.0);
        Car car8 = new Car("Benz", "EQS", 1500000.0);
        Car car9 = new Car("Audi", "e-tron", 700000.0);
        Car car10 = new Car("Audi", "R8", 2300000.0);
        List<Car> carList = Lists.newArrayList(car1, car2, car3, car4, car11, car5, car6, car7, car8, car9, car10);
        //distinct()排重,skip()跳过当前前n个元素,limit()截取,sorted()排序
        carList.stream().distinct().skip(3).limit(5).sorted((o1,o2)->o2.getPrice().compareTo(o1.getPrice())).forEach(System.out::println);
    }

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Product {
    private String name;
    private LocalDate createDate;
    private Double price;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Car{
    private String brand;
    private String type;
    private Double price;
}