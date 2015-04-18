package com.wisedu.wechat4j.examples.group;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.ResponseGroup;

import java.util.HashMap;
import java.util.Map;

// 查询用户所在分组
public class ListGroupByUser {
    private static Map<String, Object> user = new HashMap<String, Object>(){{
        put("openid", "oYiqRuKcmIVaKh6BlF7WNFlZA-cs");
    }};

    public static void main(String[] args) throws Exception {
        Wechat wechat = new WechatFactory().getInstance();
        ResponseGroup response = wechat.listGroup(user);
        if (response.getResponse().getErrCode() == 0){
            System.out.println("List Group By User Succeed." + response);
        } else {
            System.err.println("List Group By User Failed." + response);
        }
    }
}
