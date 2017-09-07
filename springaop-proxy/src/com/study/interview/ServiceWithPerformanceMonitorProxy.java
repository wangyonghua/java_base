package com.study.interview;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ServiceWithPerformanceMonitorProxy implements InvocationHandler {

    private Object target;

    public ServiceWithPerformanceMonitorProxy(Object target) {
        this.target = target;
    }

    public static Object newProxyInstance(Object target){
        Class clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new ServiceWithPerformanceMonitorProxy(target));
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(method.getName());

        Object result = method.invoke(target, args); // 通过反射执行被代理原本类的业务代码

        PerformanceMonitor.end(method.getName());

        return result;
    }
}