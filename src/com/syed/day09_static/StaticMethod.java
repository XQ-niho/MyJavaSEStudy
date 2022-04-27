package com.syed.day09_static;

/**
 * @description: static 关键字
 * @author: qiu
 * @date: 2022/3/18 14:22
 */
public class StaticMethod {

    /**静态方法可以直接通过类名.方法名方式调用,例如:Math.max(3,4)
     *     非静态方法不能直接通过类名调用,它必须创建对象,然后再调用,例如:Scanner sc = new Scanner(System.in);int i = sc.nextInt();
     *
     *     静态方法可以直接调用其他静态方法,但是不能直接调用非静态方法,调用非静态方法必须创建对象,然后再调用
     *    非静态方法可以直接调用静态方法或者非静态方法
     *
     *      注意:静态方法的调用相对比较简便,但是静态的成员在类加载的时候就会初始化到JVM的内存空间中,无论你是否去使用!
     */
    public static void main(String[] args) {

    }

    public void method1(){
        method3();
        method2();
    }

    public void method2(){

    }


    public static void method3(){

    }
}
