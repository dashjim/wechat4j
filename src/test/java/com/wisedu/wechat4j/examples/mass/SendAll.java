package com.wisedu.wechat4j.examples.mass;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.Response;

import java.util.HashMap;
import java.util.Map;

public class SendAll {
    private static Map<String, Object> news = new HashMap<String, Object>(){{
        put("filter", new HashMap<String, Object>(){{
            put("is_to_all", false);
            put("group_id", "110");
        }});
        put("mpnews", new HashMap<String, Object>(){{
            put("media_id", "XLJh7F_F4tnDgbJlgRSq9gqVh6jYQS34_eWacYJV3YyiiNHDoPyWtKInAuAuc3Ty");
        }});
        put("msgtype", "mpnews");
    }};

    public static void main(String[] args) throws Exception{
        Wechat wechat = new WechatFactory().getInstance();
        Response response = wechat.sendAll(news);
        if (response.getErrCode() == 0) {
            System.out.println("Send All Succeed." + response);
        } else {
            System.err.println("Send All Failed." + response);
        }
    }
}
