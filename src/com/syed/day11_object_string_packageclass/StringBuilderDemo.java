package com.syed.day11_object_string_packageclass;

/**
 * @description: java.lang.StringBuilder
 *
 * java.lang.StringBuilder
 * java.lang.StringBuffer
 *
 * 相同点：
 *      功能几乎完全一样
 * 不同点：
 *      StringBuilder线程不安全的，性能较高
 *      StringBuffer线程安全的，性能较低
 * @author: qiu
 * @date: 2022/3/24 11:11
 */
public class StringBuilderDemo{
    public static void main(String[] args) {
        //创建StringBuilder对象
        //注意:如果使用空参构造,则默认16个容量,如果使用字符串来构建,则容量为初始16 + 初始字符串长度
        StringBuilder stringBuilder = new StringBuilder("abc");

        /**
         * 0.获取字符串容量
         * 注意: 弹性容器在初始化时会默认分配一个容量,StringBuilder默认初始容量为16个字符,
         * 如果容器容量撑满,则会自动扩容为(原来+1)的一倍
         */
        //16 + 3
        System.out.println(stringBuilder.capacity());
        //获取字符串长度(字符数)
        //3
        System.out.println(stringBuilder.length());

        //1.拼接字符串(拼接时是加在默认容量中)
        //注意: StringBuilder的操作是针对原始字符串的操作
        stringBuilder.append("def").append("def").append("def").append("def").append("def").append("de");
        System.out.println(stringBuilder);

        System.out.println(stringBuilder.capacity());

        //2.删除指定范围的字符串方法，前闭后开
        stringBuilder.delete(0,3);

        //删除指定下标字符
        stringBuilder.deleteCharAt(0);

        //3、插入方法
        stringBuilder.insert(1,"qwe");

        //4、替换方法(指定区间)
        //与String中不一样
        stringBuilder.replace(0,3,"AAA");

        //5、字符串反转
        stringBuilder.reverse();

        /**
         * n.压缩字符串存储容量
         * 注意: 由于弹性容器实际存储的容量往往会大于真正数据的容量,所以比较浪费资源,所以我们可以通过这个方法来进行压缩
         */
        stringBuilder.trimToSize();
        System.out.println(stringBuilder.capacity());
    }

}
