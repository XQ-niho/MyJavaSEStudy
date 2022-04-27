package com.syed.day23_agent.动态代理JDK;

/**
 * description：目标类
 */
public class BookFacadeImpl implements BookFacade {
    @Override
    public void addBook() {
        System.out.println("增加图书方法。。。");
    }

    @Override
    public void deleteBook() {
        System.out.println("删除图书方法。。。");
    }

    @Override
    public void updateBook() {
        System.out.println("修改图书方法。。。");
    }

    @Override
    public void selectBook() {
        System.out.println("查询图书方法。。。");
    }
}