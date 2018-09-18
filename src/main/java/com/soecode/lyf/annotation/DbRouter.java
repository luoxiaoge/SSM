package com.soecode.lyf.annotation;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/9/7 10:48
 */
public interface DbRouter {


     String dbRoute(String field);

     String dbRouteResources(String resourceCode);

}
