package com.syed.day16_enum_innerclass;

import java.util.Arrays;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-03-31
 */
public class EnumGenderTestOfStudent {
    public static void main(String[] args) {
        Student s1 = new Student("jack", EnumOfGender.MALE);
        Student s2 = new Student("rose", EnumOfGender.FEMALE);

        //获取枚举,默认调用toString()方法,toString()方法可以覆盖
        EnumOfGender gender = s1.getGender();

        System.out.println(gender);
        System.out.println(gender.toString());
        //获取枚举名
        System.out.println(gender.name());
        //获取枚举下标
        System.out.println(gender.ordinal());

        System.out.println("----------------------------------");

        /**
         * 前端选择单选按钮后提交到后台的数据是字符串类型的
         * 0或1,m或f
         *
         * 即实际开发中,我们经常要把字符串转换成枚举类型
         */
        String str = "0";
        /**
         *  把字符串转换成枚举类型
         *  注意: 传入的字符串必须是枚举常量才能正确转换否则抛出异常:
         *  java.lang.IllegalArgumentException: No enum constant com.syedu.day12.Gender.1
         */
        //Gender gender1 = Gender.valueOf(str);

        EnumOfGender gender1 = EnumOfGender.valueOf("0".equals(str) ? "MALE" : "FEMALE");

        //补充,有的情况下,Gender都不是确定的,所以以上写法还可以改成动态版本
        EnumOfGender gender2 = Enum.valueOf(EnumOfGender.class, "0".equals(str) ? "MALE" : "FEMALE");

        System.out.println(gender1);
        System.out.println(gender2);

        System.out.println("----------------------------------");

        //把枚举中所有的枚举常量放入到数组中
        EnumOfGender[] values = EnumOfGender.values();
        System.out.println(Arrays.toString(values));
    }
}
