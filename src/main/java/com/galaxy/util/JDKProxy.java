package com.galaxy.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {

    private Object targetObject;

    /**
     * 创建目标对象的实例
     * 使用JDK动态代理，依赖于接口，需要代理的类，必须要有一个接口
     */
    public Object createNewObject(Object targetObject) {
        this.targetObject = targetObject;

        Object instance = Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(), this);

        return instance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        TransationManager tx = new TransationManager();//切面

        try {
            tx.startTransation();//开启事务，前置通知
            //需要做的事情：增删改查-CRUD
            method.invoke(targetObject, args);//切入点
            tx.commitTransation();//提交事务，后置通知
        } catch (Exception e) {
            tx.rollbackTansation();//异常通知
        } finally {
            tx.closeSession();//关闭session，最终通知
        }

        return null;
    }
}
