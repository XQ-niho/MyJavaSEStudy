package com.syed.day11_object_string_packageclass;

/**
 * @description: Object类中的clone()方法
 * @author: qiu
 * @date: 2022/3/23 10:23
 */
public class ObjectOfClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Emp emp = new Emp(4, 22, "roes");
        Emp emp1 = new Emp(5, 23, "Jerry");
        Emp emp2 = new Emp(6, 24, "Jack", new Emp[]{emp, emp1});

        /**
         * 克隆步骤
         *
         * 1、重写Object中的clone()方法，把protected修改为public
         * 2、处理clone()的异常：java.lang.CloneNotSupportedException
         * 3、clone()默认返回Object类型，需要强制类型转换
         * 4、让克隆的类实现标记接口：java.lang.Cloneable才能克隆
         */
        Emp newEmp = (Emp) emp2.clone();
        System.out.println(newEmp.toString());


        System.out.println("----------------");

        System.out.println(newEmp == emp2);


        /**
         *
         * 克隆的原理
         *  1.本体和克隆体是两个具有相同属性和行为的不同对象(内存地址不同)
         *  2.原对象和克隆对象是不公用基础属性,但是共享对象属性,
         *      即两个对象的基本类型属性(包括某些对象类型,日期,字符串...)是真正拷贝一份给新对象,所以修改A不影响B
         *      对象类型的属性时共享的,即原对象和新对象共用内存中的一份,所以修改A会影响B
         *
         * 以上结论证明了Java克隆方法默认的方式为浅层复制(基本类型复制一份,对象类型共享),
         *     如果要实现深层复制(所有属性都是拷贝一份给新对象),则必须自己写代码实现.
         */
        newEmp.setName("AA");
        System.out.println("克隆" + newEmp);
        System.out.println("原来" + emp2);

        System.out.println("---------------");

        newEmp.getEmps()[0].setName("CC");
        System.out.println("克隆" + newEmp);
        System.out.println("原来" + emp2);
    }
}
