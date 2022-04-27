package com.syed.day17_thread;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-04-02
 */
public class SingletonThreadOfStaticInnerClass {
    private SingletonThreadOfStaticInnerClass(){

    }

    private static class StaticInner{
        private static SingletonThreadOfStaticInnerClass demo = new SingletonThreadOfStaticInnerClass();
    }

    public static SingletonThreadOfStaticInnerClass getInstance(){
        return StaticInner.demo;
    }
}
