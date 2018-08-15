package com.soecode.lyf.luoc;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/8/6 16:38
 */
public  abstract class superClass implements superInterface {
    public void getMeassage() {
        try {
            System.out.println("superClass");
        }catch (Exception e){
            System.out.println("throw a Exception");
        }
    }
}
