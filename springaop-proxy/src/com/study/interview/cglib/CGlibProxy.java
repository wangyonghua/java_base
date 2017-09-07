package com.study.interview.cglib;

import com.study.interview.PerformanceMonitor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGlibProxy implements MethodInterceptor {

    //增强类的实例
    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz){
        //设置被代理类字节码，CGLIB根据字节码生成被代理类的子类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this); // 代理执行时会回调此this持有的intercept方法，以实现代码织入
        return enhancer.create();
    }

    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        PerformanceMonitor.begin(method.getName());

        Object result = methodProxy.invokeSuper(target, args);
        // 下面这样是无法执行原有方法的，因为这里的target并不是原有类的实例，而是代理类的实例
        // target : com.dianping.aop.AdminServiceImpl$$EnhancerByCGLIB$$225da297@16dd5a9d
        //Object result = method.invoke(target, args);

        PerformanceMonitor.end(method.getName());

        return result;
    }

}
   