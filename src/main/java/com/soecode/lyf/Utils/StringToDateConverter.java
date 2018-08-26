package com.soecode.lyf.Utils;


import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/8/16 11:43
 */
public class StringToDateConverter  implements Converter<String,Date>{

   // 日期类型模型
    private String dataPattern;

    public void setDataPattern(String dataPattern) {
        this.dataPattern = dataPattern;
    }

    @Override
    public Date convert(String date) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(this.dataPattern);
            //将日期字符串转换成Date类型返回
            return dateFormat.parse(date);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("转换失败");
            return null;
        }
    }

    public static void main(String[] args) {
        StringToDateConverter a = new StringToDateConverter();
        a.setDataPattern("yyyy-MM-dd");
        System.out.println(a.convert("20180606"));
    }
}
