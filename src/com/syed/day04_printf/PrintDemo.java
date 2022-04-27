package com.syed.day04_printf;

/**
 * @author qiu
 * @Description: Java输出格式化
 * @date 2022/3/10 10:03
 */
public class PrintDemo {
    public static void main(String[] args) {
        // \n换行  \r回车：光标移动到当前行的起始行  \t间隔
        System.out.println("java\nphp");
        System.out.println("122\rjava");
        System.out.println("jdu\tjava");

        //Java格式化输出
        // %s %d %f
        // 1、变量可以改变长度，%10s表示这个字符串变量占10个字符长度，默认右对齐
        // 2、变量可以改变对齐方式，默认右对齐，使用-表示左对齐，-%10s
        // 3、浮点数变量可以改变精度（四舍五入），%.2f
        String name = "TT";
        String course = "Java";
        double score = 66.0;
        System.out.printf("%s在本次%s考试的成绩为%.2f\n",name,course,score);
    }
}
