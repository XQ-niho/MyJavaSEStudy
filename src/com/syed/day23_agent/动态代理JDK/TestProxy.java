package com.syed.day23_agent.动态代理JDK;

/**
 * description：
 */
public class TestProxy {
    public static void main(String[] args) {
        //创建代理对象
        JdkProxy jdkProxy = new JdkProxy();

        BookFacade proxy = (BookFacade) jdkProxy.bind(new BookFacadeImpl());

        //调用代理对象的方法
        proxy.addBook();
        proxy.deleteBook();
        proxy.updateBook();
        proxy.selectBook();
    }
}