package com.syed.day23_agent.动态代理JDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * description：JDK动态代理
 */
public class JdkProxy implements InvocationHandler {
    private Object target;

    /**
     * 绑定委托对象并返回一个代理类
     */
    public Object bind(Object target) {
        this.target = target;
        //取得代理对象
        //注意: 此方式目标对象必须实现接口,否则无法创建代理对象(如果没有接口,则要使用第三方组件cglib来弥补实现)
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    @Override
    /**
     * 调用方法
     */
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Object result = null;
        //增强代码
        System.out.println("事物开始");
        //执行方法
        result = method.invoke(target, args);
        //增强代码
        System.out.println("事物结束");
        return result;
    }
}