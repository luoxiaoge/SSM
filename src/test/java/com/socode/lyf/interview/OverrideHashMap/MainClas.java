package com.socode.lyf.interview.OverrideHashMap;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/9/4 10:32
 */
public class MainClas
{
    public static void main(String[] args) {
        HashMap<String, Integer> a = new HashMap();
        System.out.println(a.get("kong"));
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            a.put("cesshi" + i, i);
        }
        for (int i = 0; i < 1000; i++) {
            System.out.println(a.get("cesshi" + i));
        }
        long end = System.currentTimeMillis();
        System.out.println(a.size() + "__" + (end - start));
    }

}
