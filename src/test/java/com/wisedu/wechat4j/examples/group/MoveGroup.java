package com.wisedu.wechat4j.examples.group;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.Response;

import java.util.HashMap;
import java.util.Map;

public class MoveGroup {
    private static Map<String, Object> group = new HashMap<String, Object>(){{
        put("openid", "oYiqRuKcmIVaKh6BlF7WNFlZA-cs");
        put("to_groupid", 109);
    }};

    public static void main(String[] args) throws Exception {
        Wechat wechat = new WechatFactory().getInstance();
        Response response = wechat.moveGroup(group);
        if (response.getErrCode() == 0){
            System.out.println("Move Group Succeed." + response);
        } else {
            System.err.println("Move Group Failed." + response);
        }
    }
}
