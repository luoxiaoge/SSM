package com.soecode.lyf.Intercepter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/8/16 16:03
 */
public class IntercepterJdkProxy implements InvocationHandler {

    private Object target;  //　真实对象
    private String interceptClass = null;  // 拦截器全限定名

    public IntercepterJdkProxy(Object target, String interceptClass) {
        this.target = target;
        this.interceptClass = interceptClass;
    }

    /**
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (interceptClass == null){
            // 没有设置拦截器则直接反射原有方法
             return method.invoke(target,args);
        }
        Object result = null;
        // 通过反射生成拦截器
        Intercepter intercepter = (Intercepter) Class.forName(interceptClass).newInstance();
        // 调用前置方法
        if(intercepter.before(proxy,target,method,args)){
            // 反射对象方法
            result = method.invoke(target,args);
        } else { // 返回false 执行 aroud方法
             intercepter.around(proxy,target,method,args);
        }
        // 调用后置方法
        intercepter.after(proxy,target,method,args);

        return result;
    }


    /**
     *
     * @param target
     * @param interceptClass
     * @return
     */
    public static Object bind(Object target,String interceptClass){
        // 取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),
                new IntercepterJdkProxy(target,interceptClass));
    }
}
