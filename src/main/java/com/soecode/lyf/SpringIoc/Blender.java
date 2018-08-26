package com.soecode.lyf.SpringIoc;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/8/16 16:41
 */
public class Blender {
    /**
     *  搅拌
     * @param water  水描述
     * @param fruit 水果描述
     * @param sugar 糖描述
     * @return
     *
     */
     public  String mix(String water, String fruit,  String sugar){
         String juice = water + fruit + sugar;
         return  juice;
     }
}
