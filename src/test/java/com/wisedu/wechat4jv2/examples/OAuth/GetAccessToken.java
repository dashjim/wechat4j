package com.wisedu.wechat4jv2.examples.OAuth;

import com.wisedu.wechat4jv2.api.Wechat;
import com.wisedu.wechat4jv2.client.WechatFactory;
import com.wisedu.wechat4jv2.entity.ResponseAccessToken;

import java.io.IOException;

public class GetAccessToken {
    public static void main(String args[]) throws IOException {
        Wechat wechat = new WechatFactory().getInstance();
        ResponseAccessToken token = wechat.getAccessToken();
        if (token.getResponse().getErrCode() != null) {

        } else {

        }
    }
}
