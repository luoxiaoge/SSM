package com.soecode.lyf.Intercepter;

import java.lang.reflect.Method;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/8/16 15:52
 */
public interface Intercepter {
    boolean before(Object proxy, Object target, Method method,Object[] args);

    void around(Object proxy, Object target, Method method,Object[] args);
    void after(Object proxy, Object target, Method method,Object[] args);
}
