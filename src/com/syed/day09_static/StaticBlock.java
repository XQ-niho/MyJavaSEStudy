package com.syed.day09_static;

/**
 * @description:
 * @author: qiu
 * @date: 2022/3/18 16:34
 */
public class StaticBlock {
    /*普通代码块，调用的时机是每次调用构造方法创建对象之前自动优先调用(一次或多次)
    *  注意: 普通代码块一般不使用,因为普通代码块中的代码可以直接整合到构造方法即可*/
    {
        System.out.println("普通代码块");
    }

    /*
     *  静态代码块,当类加载的时候就执行,而且有且只有一次
     * 注意: 静态代码块非常有用!我们可以利用它来完成很多费事费力,需要消耗大量系统资源的操作(前置完成)
     * 例如: 建立数据库连接池,建立数据库连接,加载大型资源配置文件....
     */
    static{
        System.out.println("静态代码块");
    }

    public StaticBlock() {
        System.out.println("StaticBlock构造方法");
    }

    public static void main(String[] args) {
        StaticBlock staticBlock = new StaticBlock();

        StaticBlock staticBlock1 = new StaticBlock();
    }
}
