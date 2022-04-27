package com.syed.day17_thread;

/**
 * @program: MyJavaSE
 * @description:
 * @author: USER
 * @create: 2022-04-02
 */
public enum SingletonThreadOfEnum {
    INSTANCE;
}

class Singleton{
    public static void main(String[] args) {
        SingletonThreadOfEnum demo = SingletonThreadOfEnum.INSTANCE;
    }
}
