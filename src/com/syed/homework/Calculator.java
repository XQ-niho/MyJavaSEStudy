package com.syed.homework;

import com.syed.util.TextInputUtil;

/**
 * @author qiu
 * @Description: 计算器
 * @date 2022/3/9 17:15
 */
public class Calculator {
    public static void main(String[] args) {

        while (true) {

            int choose = Calculator.printInfo();

            double a, b;

            for (; ; ) {
                if (choose == 1) {
                    a = TextInputUtil.getDouble("请输入被加数：");
                    b = TextInputUtil.getDouble("请输入加数：");
                    System.out.println(a + "+" + b + "=" + SimpleCalculator.sum(a, b));
                } else if (choose == 2) {
                    a = TextInputUtil.getDouble("请输入被减数：");
                    b = TextInputUtil.getDouble("请输入减数：");
                    System.out.println(a + "-" + b + "=" + SimpleCalculator.sub(a, b));
                } else if (choose == 3) {
                    a = TextInputUtil.getDouble("请输入被乘数：");
                    b = TextInputUtil.getDouble("请输入乘数：");
                    System.out.println(a + "*" + b + "=" + SimpleCalculator.mul(a, b));
                } else if (choose == 4) {
                    for (; ; ) {
                        int numOfChoose = Calculator.printDivModInfo();
                        if (numOfChoose == 1) {
                            a = TextInputUtil.getDouble("请输入被除数：");
                            b = TextInputUtil.getDouble("请输入除数：");
                            System.out.println(a + "/" + b + "=" + SimpleCalculator.div(a, b));
                        } else if (numOfChoose == 2) {
                            a = TextInputUtil.getDouble("请输入被除数：");
                            b = TextInputUtil.getDouble("请输入除数：");
                            System.out.println(a + "%" + b + "=" + SimpleCalculator.mod(a, b));
                        } else if (numOfChoose == 3) {
                            break;
                        }
                    }
                } else if (choose == 5) {
                    break;
                } else {
                    System.out.println("选择有误");
                }
            }
        }

    }

    public static int printInfo() {
        System.out.println("---Java简易计算器---\n" +
                "1、加法\n" +
                "2、减法\n" +
                "3、乘法\n" +
                "4、除余\n" +
                "5、退出");
        System.out.println("------------------");
        return TextInputUtil.getInt("请选择功能：");
    }

    public static int printDivModInfo() {
        System.out.println("1、除法\n" +
                "2、求余\n" +
                "3、返回上一层\n");
        return TextInputUtil.getInt("请您选择：");
    }

}
