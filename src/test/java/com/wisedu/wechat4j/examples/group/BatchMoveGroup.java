package com.wisedu.wechat4j.examples.group;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BatchMoveGroup {
    private static Map<String, Object> group = new HashMap<String, Object>(){{
        put("openid_list", new ArrayList<String>(){{
            add("oYiqRuKcmIVaKh6BlF7WNFlZA-cs");
        }});
        put("to_groupid", 110);
    }};

    public static void main(String[] args) throws Exception {
        Wechat wechat = new WechatFactory().getInstance();
        Response response = wechat.batchMoveGroup(group);
        if (response.getErrCode() == 0){
            System.out.println("Batch Move Group Succeed." + response);
        } else {
            System.err.println("Batch Move Group Failed." + response);
        }
    }
}
