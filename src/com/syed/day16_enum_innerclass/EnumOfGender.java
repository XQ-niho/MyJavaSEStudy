package com.syed.day16_enum_innerclass;

/**
 * @program: MyJavaSE
 * @description: 枚举
 * @author: USER
 * @create: 2022-03-31
 */
public enum EnumOfGender {
    /**
     * 枚举常量，枚举值，每一个枚举值都是当前枚举类的实例
     * 它的完整写法为：public static final MAIN = new EnumOfGender();
     */
    /*MALE() {
        @Override
        public void method2() {

        }
    }, FEMALE() {
        @Override
        public void method2() {

        }
    };*/

    MALE("男"),FEMALE("女");

    private final String info;

    EnumOfGender(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return info;
    }

    /**
     * 特点:
     * 枚举中可以有属性,属性要写在枚举常量后面
     * 枚举不能通过外界来创建对象,它的构造方法是私有化的
     * 枚举中可以有普通方法,抽象方法,但是所有枚举常量都必须重写所有的抽象方法
     * 枚举常量后面如果没有任何代码了,则结束的;可以省略
     * 枚举常量都有自己的下标,下标也是从0开始的
     */

//    public String str;
//
// 枚举不能通过外界来创建对象,它的构造方法是私有化的
//  private EnumOfGender() {
//
//  }

//    public void method() {
//
//    }

//    public abstract void method2();
}
