package com.wisedu.wechat4j.examples.template;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.Response;

import java.util.HashMap;
import java.util.Map;

public class SetIndustry {
    private static Map<String, Object> industry = new HashMap<String, Object>(){{
        put("industry_id1", "16");
        put("industry_id2", "17");
    }};

    public static void main(String[] args) throws Exception{
        Wechat wechat = new WechatFactory().getInstance();
        Response response = wechat.setIndustry(industry);
        if (response.getErrCode() == 0) {
            System.out.println("Set Industry Succeed." + response);
        } else {
            System.err.println("Set Industry Failed." + response);
        }
    }
}
