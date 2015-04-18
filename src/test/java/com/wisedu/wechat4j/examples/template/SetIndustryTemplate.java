package com.wisedu.wechat4j.examples.template;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.Response;

import java.util.HashMap;
import java.util.Map;

// 设置所属行业
public class SetIndustryTemplate {
    private static Map<String, Object> industry = new HashMap<String, Object>(){{
        put("industry_id1", "16");
        put("industry_id2", "17");
    }};

    public static void main(String[] args) throws Exception{
        Wechat wechat = new WechatFactory().getInstance();
        Response response = wechat.setIndustryTemplate(industry);
        if (response.getErrCode() == 0) {
            System.out.println("Set Industry Template Succeed." + response);
        } else {
            System.err.println("Set Industry Template Failed." + response);
        }
    }
}
