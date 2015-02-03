package com.wisedu.wechat4j.examples.kfAccount;

import com.wisedu.wechat4jv2.api.Wechat;
import com.wisedu.wechat4jv2.client.WechatFactory;
import com.wisedu.wechat4jv2.entity.Response;

import java.util.HashMap;
import java.util.Map;

public class CreateKfAccount {
    private static Map<String, Object> kfAccount = new HashMap<String, Object>() {{
        put("kf_account", "test123@gh_57372a9ae6a9");
        put("nickname", "客服1");
        put("password", "3E4AD9134F1A22443FDBAFD89CF3C093");
    }};

    public static void main(String[] args) throws Exception{
        Wechat wechat = new WechatFactory().getInstance();
        Response response = wechat.createKfAccount(kfAccount);
        if (response.getErrCode() == 0){
            System.out.println("Create KfAccount Succeed." + response);
        } else {
            System.err.println("Create KfAccount Failed." + response);
        }
    }
}
