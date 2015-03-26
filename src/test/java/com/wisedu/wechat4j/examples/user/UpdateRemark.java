package com.wisedu.wechat4j.examples.user;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.Response;

import java.util.HashMap;
import java.util.Map;

public class UpdateRemark {
    private static Map<String, Object> remark = new HashMap<String, Object>(){{
        put("openid", "oYiqRuKcmIVaKh6BlF7WNFlZA-cs");
        put("remark", "huyan");
    }};

    public static void main(String[] args) throws Exception {
        Wechat wechat = new WechatFactory().getInstance();
        Response response = wechat.updateRemark(remark);
        if (response.getErrCode() == 0) {
            System.out.println("Update Remark Succeed." + response);
        } else {
            System.err.println("Update Remark Failed." + response);
        }
    }
}
