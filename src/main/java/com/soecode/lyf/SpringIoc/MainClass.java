package com.soecode.lyf.SpringIoc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/8/16 17:02
 */
public class MainClass {

    public static void main(String[] args) {
        ApplicationContext ctc = new ClassPathXmlApplicationContext("spring/spring-xfg.xml");
        JuiceMaker2 juiceMaker2 = (JuiceMaker2) ctc.getBean("juiceMaker2");
        System.out.println(juiceMaker2.makeJuice());
    }
}
