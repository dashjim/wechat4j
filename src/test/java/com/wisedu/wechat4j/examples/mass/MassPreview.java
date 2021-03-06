package com.wisedu.wechat4j.examples.mass;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.ResponseMessage;

import java.util.HashMap;
import java.util.Map;

// 预览接口
public class MassPreview {
    private static Map<String, Object> msg = new HashMap<String, Object>(){{
        put("touser", "oYiqRuKcmIVaKh6BlF7WNFlZA-cs");
        put("mpnews", new HashMap<String, Object>(){{
            put("media_id", "XLJh7F_F4tnDgbJlgRSq9gqVh6jYQS34_eWacYJV3YyiiNHDoPyWtKInAuAuc3Ty");
        }});
        put("msgtype", "mpnews");
    }};

    public static void main(String[] args) throws Exception{
        Wechat wechat = new WechatFactory().getInstance();
        ResponseMessage response = wechat.massPreview(msg);
        if (response.getResponse().getErrCode() == 0) {
            System.out.println("Mass Preview Succeed." + response);
        } else {
            System.err.println("Mass Preview Failed." + response);
        }
    }
}
