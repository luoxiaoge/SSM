package com.soecode.lyf;

import org.junit.Test;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/8/6 16:41
 */
public class Main {

    @Test
    public void Test()  {


        System.out.println();
    }

    /**
     *  传递接口 重写接口方法
     */
    @Test
    public void testCallBack(){
         this.processChannel("luoc", new channelCallBack() {
             @Override
             public void calc(String channelCode) {
                  if ("luoc".equals(channelCode)) System.out.println("aaaa");
                  if ("zhang".equals(channelCode)) System.out.println("bbbb");
             }
         });
    }

    private void processChannel(String userId,channelCallBack channelCallBack){
          channelCallBack.calc(userId);
    }

    interface  channelCallBack{
        void calc(String channelCode);
    }


}
