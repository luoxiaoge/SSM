package com.soecode.lyf.Utils;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/9/6 16:27
 */
public class HashFunction
{
    public  int user(String  userName){
         int result =  Math.abs(userName.hashCode()%1024);

         if (0 <= result && result<= 255){
              return  1;
         }else if (result > 255){
             return  2;
         }else {
             return  2;
         }
    }

    public static void main(String[] args) {
        // luoc 285  luo 6
        System.out.println("luo".hashCode()%1024);
    }

}
