package com.wisedu.wechat4j.examples.shortURL;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.ResponseShortURL;

import java.util.HashMap;
import java.util.Map;

public class CreateShortURL {
    private static Map<String, Object> longURL = new HashMap<String, Object>(){{
        put("action", "long2short");
        put("long_url", "http://wechat.ngrok.com/tSow/wechat/wechat.do");
    }};

    public static void main(String[] args) throws Exception{
        Wechat wechat = new WechatFactory().getInstance();
        ResponseShortURL response = wechat.createShortURL(longURL);
        if (response.getResponse().getErrCode() == 0) {
            System.out.println("Create Short URL Succeed." + response);
        } else {
            System.err.println("Create Short URL Failed." + response);
        }
    }
}