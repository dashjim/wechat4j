package com.wisedu.wechat4j.examples.group;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.Response;

import java.util.HashMap;
import java.util.Map;

public class UpdateGroup {
    private static Map<String, Object> group = new HashMap<String, Object>(){{
        put("group", new HashMap<String, Object>(){{
            put("id", 109);
            put("name", "分组二");
        }});
    }};

    public static void main(String[] args) throws Exception{
        Wechat wechat = new WechatFactory().getInstance();
        Response response = wechat.updateGroup(group);
        if (response.getErrCode() == 0){
            System.out.println("Update Group Succeed." + response);
        } else {
            System.err.println("Update Group Failed." + response);
        }
    }
}
