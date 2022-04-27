package com.syed.day04_printf;

/**
 * @author qiu
 * @Description: 递归
 * @date 2022/3/10 11:05
 */
public class RecursiveDemo {
    public static void main(String[] args) {

    }


    public static int age(int people) {
        if (people == 1) {
            return 10;
        }
        return age(people - 1) + 2;
    }
    /**
     * 斐波那契
     */
    public static int fibonacciSequence(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacciSequence(n - 1) + fibonacciSequence(n - 2);

    }
    /**
     * 杨辉三角
     */
    public static int pascalTriangle(int row, int col) {
        if (row == 1 || col == 1 || row == col) {
            return 1;
        }
        return pascalTriangle(row - 1, col - 1) + pascalTriangle(row - 1, col);
    }

    /**
     * 汉诺塔
     */
    private static void towerOfHand(String a, String b, String c, int n) {
        if (n == 1) {
            System.out.println("把第" + n + "个盘从" + a + "移动到" + c);
        } else {
            towerOfHand(a, c, b, n - 1);
            System.out.println("把第" + n + "个盘从" + a + "移动到" + c);
            towerOfHand(b, a, c, n - 1);
        }
    }
}
