package com.wisedu.wechat4j.examples.kfAccount;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.Response;

import java.util.HashMap;
import java.util.Map;

// 客服接口-发消息
public class SendMessage {
    private static Map<String, Object> message = new HashMap<String, Object>() {{
        put("touser", "oYiqRuKcmIVaKh6BlF7WNFlZA-cs");
        put("msgtype", "text");
        put("text", new HashMap<String, Object>(){{
            /*put("content", "Hello World");*/
            put("content", "<a href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxeb08f90467938ff7&redirect_uri=http%3A%2F%2Fwechat.ngrok.com%2FtShow%2FWechat.do&response_type=code&scope=snsapi_userinfo&state=state#wechat_redirect'>haha</a>");
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
