package com.wisedu.wechat4jv2.examples.auth;
import com.wisedu.wechat4jv2.client.WechatClient;

import java.io.IOException;
import java.util.Date;

public class GetToken {
    public static void main(String[] args){
        System.out.println(new Date(1418368454000L));
        try {
            WechatClient client = new WechatClient();
            AccessToken token = client.getAuthAccessToken();
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
