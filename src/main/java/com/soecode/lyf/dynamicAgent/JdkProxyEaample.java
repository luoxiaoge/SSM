package com.soecode.lyf.dynamicAgent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/8/15 17:12
 */
public class JdkProxyEaample implements InvocationHandler {
    //
    private Object target = null;

    public Object bind(Object target){
         this.target = target;
         return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);

    }

    @Override
    public  Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("进入代理方法");
        System.out.println("在调度真实对象之前的服务");

        Object object = method.invoke(target,args);
        //　相当于调用 sayHelloWorld 方法

        System.out.println("在调用真实对象之后的服务");
        return object;
    }


}
