package com.wisedu.wechat4j.examples.group;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.ResponseGroup;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CreateGroup {
    private static Map<String, Object> group = new HashMap<String, Object>(){{
        put("group", new HashMap<String, Object>(){{
            put("name", "分组一");
        }});
    }};

    public static void main(String[] args) throws IOException {
        Wechat wechat = new WechatFactory().getInstance();
        ResponseGroup responseGroup = wechat.createGroup(group);
        if (responseGroup.getResponse().getErrCode() == 0){
            System.out.println("List Group Succeed." + responseGroup);
        } else {
            System.err.println("List Group Failed." + responseGroup);
        }
    }
}
