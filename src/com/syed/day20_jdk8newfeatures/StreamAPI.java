package com.syed.day20_jdk8newfeatures;

import com.google.common.collect.Lists;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @program: MyJavaSE
 * @description: JDK8.0新特性：Stream流式API
 * 惰性计算
 * @author: USER
 * @create: 2022-04-08
 */
public class StreamAPI {
    public static void main(String[] args) {
        /**
         * 创建流对象
         */
        //1、一般在测试中使用(不推荐)
        Stream<Integer> stream = Stream.of(10, 20, 30);
        stream.forEach(System.out::println);

        //2、基于数组或集合(常用)
        Stream<String> stream1 = Arrays.stream(new String[]{"AA", "BB", "CC"});
        Stream<Integer> stream2 = Lists.newArrayList(10, 20, 30).stream();

        //3、基于Supplier
        Stream<Integer> stream3 = Stream.generate(new Supplier<Integer>() {
            private int num = 0;

            @Override
            public Integer get() {
                return num++;
            }
        });
        stream3.limit(100).forEach(System.out::println);

        //4、其他方法，某些类中的方法可以得到Stream
        try {
            //注意:如果得到集合,则相当于已经把所有数据加载到内存中了,但是Stream的方式相当于先订立契约,没有真正的加载数据,所以内存开销极少,效率较高
            //List<String> stringList = Files.readAllLines(Path.of("D:\\BAM练习.txt"));
            Stream<String> lines = Files.lines(Paths.get(""));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //补充: Stream泛型不支持基本类型,所以Java额外提供了几个类来支持基本类型的Stream操作,IntStream,LongStream,DoubleStream...
        IntStream intStream = Arrays.stream(new int[]{1, 2, 3, 4, 56, 4});


        //斐波那契数列
        Stream.generate(new Supplier<BigInteger>() {
            BigInteger n1 = BigInteger.ZERO, n2 = BigInteger.ZERO, n3 = BigInteger.ONE;

            @Override
            public BigInteger get() {
                n1 = n2;
                n2 = n3;
                n3 = n1.add(n2);
                return n2;
            }
        }).limit(10).forEach(System.out::println);


        //字符串转日期
        ArrayList<String> dateTime = Lists.newArrayList("2022-10-01", "2021-12-25");
        dateTime.stream().map(LocalDate::parse).forEach(System.out::println);
    }
}
