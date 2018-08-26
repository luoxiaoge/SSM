package com.soecode.lyf.CGLIBDynamicAgent;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/8/16 14:56
 */
public class CglibProxyExample implements MethodInterceptor{



    public Object getProxy(Class cls){
        // CGLIB enhancer增强类对象
        Enhancer enhancer = new Enhancer();
        // 设置增强类型
        enhancer.setSuperclass(cls);
        //定义代理逻辑对象 为当前对象， 要求当前对象实现 MethodIntercepter 方法
        enhancer.setCallback(this);
        // 生成返回代理对象
        return  enhancer.create();


    }


    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用对象之前>>>>>>> ");
        Object result = methodProxy.invokeSuper(proxy,args);
        System.out.println("调用对象之后》》》》》");
        return result;
    }
}
