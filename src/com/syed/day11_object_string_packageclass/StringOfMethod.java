package com.syed.day11_object_string_packageclass;

import java.util.Arrays;

/**
 * @description: java.lang.String常用方法
 * @author: qiu
 * @date: 2022/3/23 15:53
 */
public class StringOfMethod {
    public static void main(String[] args) {
        /**
         * 0.把字符串转换成字节数组
         * 作用: 字符串乱码硬编码,后面我们会利用此手段对字符串进行乱码矫正操作
         */
        byte[] bytes = "你好,ABC".getBytes();

        /**
         * 1.获取字符串指定下标处的字符
         * 注意: 字符串和数组一样也有下标,从0开始,到字符串长度-1为止,
         * 如果访问时超过下标范围,抛出字符串下标越界异常: java.lang.StringIndexOutOfBoundsException
         */
        char firstLetter = "abc123".charAt(0);
        System.out.println(firstLetter);

        /**
         *2.字符串比较方法
         * 通过正零负,来区别大等小,返回整数类型
         * 即如果A>B,则得到正数,A<B,则得到负数,A=B,则得到0
         */
        int compareTo = "abc".compareTo("ABC");
        System.out.println(compareTo);

        //忽略大小写
        int compareToIgnoreCase = "abc".compareToIgnoreCase("ABC");
        System.out.println(compareToIgnoreCase);

        /**
         * 3.字符串连接方法
         */
        String concat = "abc".concat("def");
        System.out.println(concat);

        /**
         * 4.判断字符串中是否包含指定的内容
         */
        boolean contains = "你好,我是Java程序员.".contains("Java");
        System.out.println(contains);

        /**
         * 5.判断字符串是否以指定内容开头或者结尾
         */
        boolean startsWith = "队长-哪里都是你.mp3".startsWith("队长");
        boolean endsWith = "队长-哪里都是你.mp3".endsWith("mp3");
        System.out.println(startsWith);
        System.out.println(endsWith);

        /**
         * 6.字符串比较,返回boolean类型
         * 注意: 一般我们在使用equals()判断时,要把字面量写在equals()前面,从而避免空指针的判定
         *
         * 技巧:
         *         String name = null;
         *         if("abc".equals(name)){
         *             System.out.println("OK");
         *         }else{
         *             System.out.println("不OK");
         *         }
         */
        System.out.println("abc".equals("ABC"));
        System.out.println("abc".equalsIgnoreCase("ABC"));

        /**
         * 7.获取字符串中指定内容首次出现或者最后一次出现的下标
         * 注意: 可以通过传入第二个参数来从指定位置开始找,第二个参数是包含的!!!
         *      如果字符串中没有找到指定的内容,则返回-1
         */
        int firstB = "abc,abc,abc".indexOf("b");
        System.out.println(firstB);
        //获取字符串第二次出现的b
        int secondB = "abc,abc,abc".indexOf("b", firstB + 1);
        System.out.println(secondB);

        int lastIndexOf = "abc,abc,abc".lastIndexOf("b");
        System.out.println(lastIndexOf);

        /**
         * 8.获取字符串长度(字符数)
         */
        int length = "abc,abc".length();
        System.out.println(length);

        /**
         * 9.判断字符串是否为空
         * 注意:  "".length==0  等价 "".isEmpty()
         */
        boolean empty = "".isEmpty();
        System.out.println(empty);

        /**
         * 10.重复字符串
         * 注意: 此方法JDK要求11及其以上!!!
         */
//        String repeat = "abc".repeat(3);
//        System.out.println(repeat);

        /**
         * 11.替换字符串指定内容
         */
        String replace = "你好,我是Python程序员,Python YYDS!!!".replace("Python", "Java");
        System.out.println(replace);

        /**
         * 12.以指定的内容来切割字符串,返回字符串数组
         */
        String[] strings = "AAA-BBB-CCC-DDD".split("-");
        System.out.println(Arrays.toString(strings));

        /**
         * 13.截取字符串
         * 注意:
         * 一个参数表示从此下标处开始截取到字符串末尾
         * 两个参数表示从开始下标(包括)截取到结束下标(不包括)区间的字符串
         */
        String substring = "aaabbbcccdddeeefff".substring(3, 6);
        System.out.println(substring);

        /**
         * 14.转换字符串大小写
         */
        String upperCase = "abc".toUpperCase();
        String lowerCase = "ABC".toLowerCase();
        System.out.println(upperCase);
        System.out.println(lowerCase);

        /**
         * 15.把字符串转换成字符数组
         * 注意: 字符串的本质其实就是字符数组
         */
        char[] chars = "abcdef".toCharArray();
        System.out.println(Arrays.toString(chars));

        //把字符数组转换回字符串
        String newStr = String.valueOf(chars);
        System.out.println(newStr);

        /**
         * 16.除去字符串前后空白
         */
        String trim = "    abc      ".trim();
        System.out.println(trim);
    }

}
