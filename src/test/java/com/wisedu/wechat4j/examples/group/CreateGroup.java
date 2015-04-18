package com.wisedu.wechat4j.examples.group;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.ResponseGroup;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// 创建分组
public class CreateGroup {
    private static Map<String, Object> group = new HashMap<String, Object>(){{
        put("group", new HashMap<String, Object>(){{
            put("name", "分组一");
        }});
    }};

    public static void main(String[] args) throws IOException {
        Wechat wechat = new WechatFactory().getInstance();
        ResponseGroup response = wechat.createGroup(group);
        if (response.getResponse().getErrCode() == 0){
            System.out.println("List Group Succeed." + response);
        } else {
            System.err.println("List Group Failed." + response);
        }
    }
}
