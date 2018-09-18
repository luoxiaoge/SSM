package com.socode.lyf.interview.JVM;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/9/5 11:51
 */
public class MyTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
            MyClassLoader loader = new MyClassLoader("Luoc","E:/tmp/");
            Class<?> c = loader.loadClass("Demo");
            c.newInstance();
            //loader.ge("Demo");
    }

}
