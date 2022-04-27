package com.syed.day08_inherit_polymorphism.polymorphismv1;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/17 15:12
 */
public class Car extends Vehicle {
    /**
     * Java方法重写
     * 子类覆盖与父类相同的方法,即子类中会把父类方法的功能进行改写
     *
     * 重写达成要求:
     * 前提条件,发生在两个类中,而且这两个类存在父子类继承关系
     *
     * 方法名必须相同,参数列表必须相同,返回类型必须相同
     * 修饰符可以不同,要求,子类重写方法的修饰符控制范围必须大于等于父类的修饰符
     *      public > protected > [] > private
     *
     * 抛出的异常可以不同(需要满足一定的条件)
     *
     * 注意:
     *  @Override
     *  表示被修饰的方法是重写方法,它只是一个检测作用,用来检测被修饰的方法是否是重写方法
     */
    @Override
    public void move(){
        System.out.println("Car--drive");
    }
}
