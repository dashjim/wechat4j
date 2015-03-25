package com.wisedu.wechat4j.examples.mass;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.Response;
import com.wisedu.wechat4j.entity.ResponseMassMessage;

import java.util.HashMap;
import java.util.Map;

public class GetMessage {
    private static Map<String, Object> msg = new HashMap<String, Object>(){{
        put("msg_id", 2356577100L);
    }};

    public static void main(String[] args) throws Exception{
        Wechat wechat = new WechatFactory().getInstance();
        ResponseMassMessage response = wechat.massGet(msg);
        if (response.getResponse().getErrCode() == 0) {
            System.out.println("Get Message Succeed." + response);
        } else {
            System.err.println("Get Message Failed." + response);
        }
    }
}
