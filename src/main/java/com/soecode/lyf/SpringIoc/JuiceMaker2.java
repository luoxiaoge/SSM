package com.soecode.lyf.SpringIoc;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/8/16 16:51
 */
public class JuiceMaker2 {

    private  String beverageShop = null;
    private Source  source =null;

    public String getBeverageShop() {
        return beverageShop;
    }

    public void setBeverageShop(String beverageShop) {
        this.beverageShop = beverageShop;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String makeJuice() {
        return "JuiceMaker2{" +
                "beverageShop='" + beverageShop + '\'' +
                ", source=" + source +
                '}';
    }
}
