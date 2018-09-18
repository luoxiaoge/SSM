package com.socode.lyf.interview.OverrideHashMap;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/9/4 9:36
 */
public interface Map<K,V> {

     V get(K k);

     V put(K k,V v);

     int size();


    interface Entry<K,V>{
         K  getKey();

         V getValue();

     }





}
