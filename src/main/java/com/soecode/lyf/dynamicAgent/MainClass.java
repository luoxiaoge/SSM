package com.soecode.lyf.dynamicAgent;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/8/15 17:18
 */
public class MainClass  {

    public static void main(String[] args) {
        JdkProxyEaample jdkProxyEaample = new JdkProxyEaample();
        // 绑定关系
        HelloWorld proxy = (HelloWorld) jdkProxyEaample.bind(new HelloWorldImpl());
        proxy.sayHellWorld();
    }


}
