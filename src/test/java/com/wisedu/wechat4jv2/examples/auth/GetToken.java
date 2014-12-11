package com.wisedu.wechat4jv2.examples.auth;
import com.wisedu.wechat4jv2.client.WechatClient;
import com.wisedu.wechat4jv2.enity.AccessToken;

import java.io.IOException;

public class GetToken {
    public static void main(String[] args){
        try {
            WechatClient client = new WechatClient();
            AccessToken token = client.getAccessToken();
            if (token.getResponse().getErrCode() == null){
                System.out.println("Get Token Succeed." + token);
            } else {
                System.err.println("Get Token Failed." + token);
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
