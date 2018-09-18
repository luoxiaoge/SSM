package com.socode.lyf.interview.JVM;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/9/4 11:47
 */
public class B {
    public static void main(String[] args) {
        System.out.println(B.class.getClassLoader());
        ClassLoader loader = B.class.getClassLoader();
        while (loader!=null){
            System.out.println(loader);
            loader = loader.getParent();
        }
        System.out.println(loader);
    }
}
