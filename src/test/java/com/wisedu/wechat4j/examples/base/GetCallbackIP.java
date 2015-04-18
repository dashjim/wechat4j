package com.wisedu.wechat4j.examples.base;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.ResponseCallbackIP;

// 获取微信服务器IP地址
public class GetCallbackIP {
    public static void main(String args[]) throws Exception {
        Wechat wechat = new WechatFactory().getInstance();
        ResponseCallbackIP response = wechat.getCallbackIP();
        if (response.getResponse().getErrCode() == 0){
            System.out.println("Get Callback IP Succeed." + response);
        } else {
            System.err.println("Get Callback IP Failed." + response);
        }
    }
}
