package com.wisedu.wechat4j.examples.auth;

import com.wisedu.wechat4j.WechatException;
import com.wisedu.wechat4j.client.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.AccessToken;

public class GetToken {
    private static final String oauthToken = "tShow";
    private static final String oauthAppID = "wxeb08f90467938ff7";
    private static final String oauthAppSecret = "504581525da6402ed53d2b82766d95c1";

    public static void main(String[] args){
        try {
            System.out.println(System.currentTimeMillis());
            Wechat wechat = WechatFactory.createWechatInstance();
            wechat.setOAuthApp(oauthToken, oauthAppID, oauthAppSecret);
            AccessToken token = wechat.getAccessToken();
            if (token.getResponse().getErrCode() == null){
                System.out.println("Get Token Succeed." + token);
            } else {
                System.err.println("Get Token Failed." + token);
            }
        } catch (WechatException we){
            we.printStackTrace();
        }
    }
}