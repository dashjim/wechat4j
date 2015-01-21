package com.wisedu.wechat4jv2.examples.oauth;

import com.wisedu.wechat4jv2.api.Wechat;
import com.wisedu.wechat4jv2.client.WechatFactory;
import com.wisedu.wechat4jv2.entity.ResponseAccessToken;

import java.io.IOException;

public class GetToken {
    public static void main(String args[]) throws IOException {
        Wechat wechat = new WechatFactory().getInstance();
        ResponseAccessToken token = wechat.getAccessToken();
        if (token.getResponse().getErrCode() == 0){
            System.out.println("Get Token Succeed." + token);
        } else {
            System.err.println("Get Token Failed." + token);
        }
    }
}
