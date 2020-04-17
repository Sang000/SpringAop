package com.galaxy.util;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CGLIBProxy implements MethodInterceptor {

    private Object targetObject;

    /**
     * 创建目标对象的实例
     */

    public Object createNewObject(Object targetObject) {
        this.targetObject = targetObject;

        //1.CGLIB库中 创建代理方式
        Enhancer enhancer = new Enhancer();
        //2. 设置目标类（让代理类派生子类），并重写 目标类的非final方法
        enhancer.setSuperclass(targetObject.getClass());
        //3.设置回调方法
        enhancer.setCallback(this);
        //4. 创建代理类，这个代理类是目标类的子类
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        try {
            System.out.println("开启事物");
            Object obj = methodProxy.invoke(this.targetObject, args);
            System.out.println("提交事物");
            return obj;
        } catch (RuntimeException e) {
            System.out.println("回滚事物");
        } finally {
            System.out.println("关闭session");
        }
        return null;
    }
}
