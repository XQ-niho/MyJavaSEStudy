package com.syed.day23_agent.动态代理cglib;

import org.junit.Test;

public class TestCglib {
    @Test
    public void test() {
        CglibProxy cglib = new CglibProxy();
        BookFacadeImpl bookCglib = (BookFacadeImpl) cglib.getInstance(new BookFacadeImpl());
        bookCglib.addBook();
        bookCglib.deleteBook();
    }
}