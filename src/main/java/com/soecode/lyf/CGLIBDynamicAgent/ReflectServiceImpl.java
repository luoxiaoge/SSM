package com.soecode.lyf.CGLIBDynamicAgent;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/8/16 15:19
 */
public class ReflectServiceImpl {

    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ReflectServiceImpl{" +
                "name='" + name + '\'' +
                '}';
    }

    public void  sayHello(){
        System.out.println("Hello World");
    }
}
