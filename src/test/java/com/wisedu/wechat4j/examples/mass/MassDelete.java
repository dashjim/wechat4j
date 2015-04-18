package com.wisedu.wechat4j.examples.mass;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.Response;

import java.util.HashMap;
import java.util.Map;

public class MassDelete {
    private static Map<String, Object> msg = new HashMap<String, Object>(){{
        put("msg_id", 2356577100L);
    }};

    public static void main(String[] args) throws Exception{
        Wechat wechat = new WechatFactory().getInstance();
        Response response = wechat.massDelete(msg);
        if (response.getErrCode() == 0) {
            System.out.println("Mass Delete Succeed." + response);
        } else {
            System.err.println("Mass Delete Failed." + response);
        }
    }
}
