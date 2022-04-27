package com.syed.day11_object_string_packageclass;

/**
 * @description: java.lang.String类
 * 不变类，字符串一旦创建，无法改变
 * @author: qiu
 * @date: 2022/3/23 15:03
 */
public class StringOfCreat {
    public static void main(String[] args) {
        /**
         * 字符串的创建方式：
         * 1、通过new来创建字符串对象
         */
        String s = new String("123ABC");
        String s1 = new String("123ABC");

        //false
        System.out.println(s == s1);
        //true
        System.out.println(s.equals(s1));

        /** 2、串池创建（推荐）
         * 原理:
         *    当创建第一个字符串的时候,本质上用的是new来创建,则在内存堆中开辟空间保存创建的字符串对象,
         *    然后在栈中保存s2这个引用,内部存储的是字符串对象的内存地址,(多出一步)另外会把该字符串保存
         *    到串池中(专门方字符串的空间,本质上也是内存空间)
         *    当第二次创建字符串时,会先去串池中搜索是否有相同值的字符串,如果有,则把该对象的内存地址赋值
         *    给新的引用,如果没有,则直接重新new
         * */
        String s2 = "123ABC";
        String s3 = "123ABC";
        //true
        System.out.println(s2 == s3);
        //true
        System.out.println(s2.equals(s3));

        /**
         * 字符串拼接
         * 字符串是一个不变类,所以一旦创建无法改变,即无法进行动态的增长与缩短
         *
         * 注意:以下代码一共会在内存中产生3个不同的字符串对象,即字符串拼接时会产生新的字符串对象,而不是在原有字符串基础上改变的!!!
         *
         * 解决办法:使用java.lang.StringBuilder类,它是一个动态字符串类,弹性容器,即拼接时会在自身上增长,不会产生额外对象
         *
         * 结论:原始字符串拼接的性能极差,因为每次拼接都会产生新的额外对象,消耗内存空间,所以拼接时推荐使用StringBuilder来替代使用.
         *
         * 注意: JDK5.0之后+拼接方式会自动转换成StringBuilder的append()拼接方式来提升拼接效率,但是
         *      这种方式在循环中不能起效
         *
         * String str1 = "abc";
         * String str2 = "def";
         * String str3 = str1 + str2;
         * System.out.println(str3);
         */
        //测试字符串拼接
        String str = "abc";

        //StringBuilder stringBuilder = new StringBuilder("abc");

        //获取当前系统时间的毫秒数,从1970.1.1 0:0:0(CST+8)开始计算的到你程序运行此行代码的毫秒数
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {

            str += "def";

            //stringBuilder.append("def");
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms.");


    }
}
