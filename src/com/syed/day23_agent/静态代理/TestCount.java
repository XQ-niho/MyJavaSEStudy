package com.syed.day23_agent.静态代理;

import org.junit.Test;

/**
 * description：
 * @author Administrator
 * @date 2021/9/26 15:10
 */
public class TestCount {
    @Test
    public void test() {
        //创建目标对象
        CountImpl countImpl = new CountImpl();
        //创建代理对象,传入目标对象
        CountProxy countProxy = new CountProxy(countImpl);
        //调用代理对象的核心方法,本质就是目标对象的核心方法,不过是增强版的
        countProxy.queryCount();
        countProxy.updateCount();
    }
}