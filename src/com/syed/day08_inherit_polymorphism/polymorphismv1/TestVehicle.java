package com.syed.day08_inherit_polymorphism.polymorphismv1;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/17 15:21
 */
public class TestVehicle {
    public static void main(String[] args) {
        /**
         * 多态应用之一
         * 创建对象时，编译时类型写成父类
         *
         * 注意：
         * 编译时类型表示对象编译时的类型
         * 运行时类型表示对象正真的类型
         *
         * 例如: car的编译时类型是Vehicle(父类类型,体现多态),运行时类型是Car
         *
         * 优点: 类型父类化,则该对象可以描述父类下的任何一个子类,包括后期的拓展
         * 缺点: 它只能访问父类的成员,无法访问子类特有的成员
         *
         * 注意:
         * 对象可以访问的属性和方法是由它的编译时类型来决定的!!!
         * 子类继承父类,如果使用多态,编译时类型写成父类,则子类只能访问到父类的公共方法,无法访问其自己的特有方法,
         * 但是,我们可以通过强制类型转换类解决该问题,强制类型转换的本质就是把编译时类型从父类改成它真正的子类类型
         *
         * 强制类型转换前一定要进行类型判断(instanceof),否则可能会出现类型转换异常:java.lang.ClassCastException
         */

        Vehicle v1 = new Car();
        Vehicle v2 = new Bike();
        Vehicle v3 = new Plane();

        Vehicle[] vehicles = {v1, v2, v3};

        for (Vehicle v : vehicles) {
            if (v instanceof Car) {
                ((Car) v).move();
            }

            if(v instanceof Bike){
                ((Bike) v).move();
            }

            if(v instanceof Plane){
                ((Plane) v).move();
            }
        }
    }
}
