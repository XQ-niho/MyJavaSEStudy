package com.syed.day23_agent.动态代理cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * description：使用cglib动态代理
 * 基于父子类继承关系,在内存中动态生成一个子类对象,对核心方法进行增强
 *
 * 注意: 此方法需要导入第三方Jar包
 */
public class CglibProxy implements MethodInterceptor {
    private Object target;

    /**
     * 创建代理对象
     */
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        //设置父类(目标类型)
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    @Override
    // 回调方法
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
        System.out.println("事物开始");
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("事物结束");
        return result;
    }
}