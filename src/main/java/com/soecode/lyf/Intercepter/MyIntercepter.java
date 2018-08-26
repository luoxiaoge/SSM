package com.soecode.lyf.Intercepter;

import java.lang.reflect.Method;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/8/16 15:51
 */
public class MyIntercepter implements  Intercepter{

    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("放射方法前逻辑");
        return true;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("取代了被代理对象的方法");
    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("反射方法后逻辑");
    }
}
