package com.soecode.lyf.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/9/7 10:24
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Router {

    String routerField() default "username";


    String tableStyle() default "0" ;

}
