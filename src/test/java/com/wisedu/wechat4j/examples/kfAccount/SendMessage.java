package com.wisedu.wechat4j.examples.kfAccount;

import com.wisedu.wechat4jv2.api.Wechat;
import com.wisedu.wechat4jv2.client.WechatFactory;
import com.wisedu.wechat4jv2.entity.Response;

import java.util.HashMap;
import java.util.Map;

public class SendMessage {
    private static Map<String, Object> message = new HashMap<String, Object>() {{
        put("touser", "oYiqRuKcmIVaKh6BlF7WNFlZA-cs");
        put("msgtype", "text");
        put("text", new HashMap<String, Object>(){{
            put("content", "Hello World");
        }});
    }};

    public static void main(String[] args) throws Exception {
        Wechat wechat = new WechatFactory().getInstance();
        Response response = wechat.sendMessage(message);
        if (response.getErrCode() == 0){
            System.out.println("Send Message Succeed." + response);
        } else {
            System.err.println("Send Message Failed." + response);
        }
    }
}
