package com.wisedu.wechat4j.examples.template;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.ResponseTemplate;

import java.util.HashMap;
import java.util.Map;

public class AddTemplate {
    private static Map<String, Object> template = new HashMap<String, Object>(){{
        put("template_id_short", "TM00080");
    }};

    public static void main(String[] args) throws Exception{
        Wechat wechat = new WechatFactory().getInstance();
        ResponseTemplate response = wechat.addTemplate(template);
        if (response.getResponse().getErrCode() == 0) {
            System.out.println("Add Template Succeed." + response);
        } else {
            System.err.println("Add Template Failed." + response);
        }
    }
}