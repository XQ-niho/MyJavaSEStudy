package com.syed.homework.test2;

import com.syed.homework.test1.Test1;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/20 21:07
 */
public class Test2 extends Test1 {
    private String method = "xxx";
    public static void main(String[] args) {
        Test2 x = new Test2();
        System.out.println(x.method);
        x.method();
    }

    public void method(){
        System.out.println(111);
    }
}
