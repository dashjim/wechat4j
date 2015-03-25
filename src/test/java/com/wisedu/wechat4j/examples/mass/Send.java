package com.wisedu.wechat4j.examples.mass;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.ResponseMassMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Send {
    private static Map<String, Object> msg = new HashMap<String, Object>(){{
        put("touser", new ArrayList<String>(){{
            add("oYiqRuKcmIVaKh6BlF7WNFlZA-cs");
        }});
        put("mpnews", new HashMap<String, Object>(){{
            put("media_id", "XLJh7F_F4tnDgbJlgRSq9gqVh6jYQS34_eWacYJV3YyiiNHDoPyWtKInAuAuc3Ty");
        }});
        put("msgtype", "mpnews");
    }};

    public static void main(String[] args) throws Exception{
        Wechat wechat = new WechatFactory().getInstance();
        ResponseMassMessage response = wechat.massSend(msg);
        if (response.getResponse().getErrCode() == 0) {
            System.out.println("Send Succeed." + response);
        } else {
            System.err.println("Send Failed." + response);
        }
    }
}
