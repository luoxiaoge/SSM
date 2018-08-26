package com.soecode.lyf.Intercepter;

import com.soecode.lyf.dynamicAgent.HelloWorld;
import com.soecode.lyf.dynamicAgent.HelloWorldImpl;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/8/16 16:13
 */
public class MainClass {

    public static void main(String[] args) {
        HelloWorld proxy = (HelloWorld) IntercepterJdkProxy.bind(new HelloWorldImpl(),"com.soecode.lyf.Intercepter.MyIntercepter");
        proxy.sayHellWorld();
    }
}
