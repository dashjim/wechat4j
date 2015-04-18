package com.wisedu.wechat4j.examples.group;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// 删除分组
public class DeleteGroup {
    private static Map<String, Object> group = new HashMap<String, Object>(){{
        put("group", new HashMap<String, Object>(){{
            put("id", "101");
        }});
    }};

    public static void main(String[] args) throws IOException {
        Wechat wechat = new WechatFactory().getInstance();
        Response response = wechat.deleteGroup(group);
        if (response.getErrCode() == 0){
            System.out.println("Delete Group Succeed." + response);
        } else {
            System.err.println("Delete Group Failed." + response);
        }
    }
}
