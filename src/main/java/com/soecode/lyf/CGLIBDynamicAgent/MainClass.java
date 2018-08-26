package com.soecode.lyf.CGLIBDynamicAgent;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/8/16 15:20
 */
public class MainClass {
    public static void main(String[] args) {
        CglibProxyExample a = new CglibProxyExample();
        ReflectServiceImpl b = (ReflectServiceImpl) a.getProxy(ReflectServiceImpl.class);

        b.sayHello();

    }
}
