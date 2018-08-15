package com.soecode.lyf.luoc;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/8/6 16:39
 */
public class ImplemetnsClass extends superClass {

    @Override
    public void getMeassage()  {
        try {
             int a = 10 / 0;
         }catch (ArithmeticException e){
             System.out.println(e.getMessage());
         }
    }
}
