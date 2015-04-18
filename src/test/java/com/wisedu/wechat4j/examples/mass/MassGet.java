package com.wisedu.wechat4j.examples.mass;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.ResponseMessage;

import java.util.HashMap;
import java.util.Map;

public class MassGet {
    private static Map<String, Object> msg = new HashMap<String, Object>(){{
        put("msg_id", 2356577100L);
    }};

    public static void main(String[] args) throws Exception{
        Wechat wechat = new WechatFactory().getInstance();
        ResponseMessage response = wechat.massGet(msg);
        if (response.getResponse().getErrCode() == 0) {
            System.out.println("Mass Get Succeed." + response);
        } else {
            System.err.println("Mass Get Failed." + response);
        }
    }
}
