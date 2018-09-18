package com.socode.lyf.interview.JVM;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/9/4 11:20
 */
public class A
{

    static {
        tmp = 2;
       // System.out.println(tmp);
    }
    public static  int tmp = 1;

    public static void main(String[] args) {
        tmp =3;
        System.out.println(tmp);
    }

}
