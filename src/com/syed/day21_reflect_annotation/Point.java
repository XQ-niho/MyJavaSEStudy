package com.syed.day21_reflect_annotation;

/**
 * description：
 * @author Administrator
 * @date 2022/4/8 16:42
 */
public class Point implements IA, IB {
    private int x;
    private int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void method1() {
        System.out.println("Point.method1");
    }

    public void method2(int x, int y) {
        System.out.println("Point.method2");
    }

    public int method3() {
        System.out.println("Point.method3");
        return x + y;
    }

    private void method4() {
        System.out.println("Point.method4");
    }
}