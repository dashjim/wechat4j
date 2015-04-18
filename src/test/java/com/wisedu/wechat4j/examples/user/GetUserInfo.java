package com.wisedu.wechat4j.examples.user;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.ResponseUser;

// 获取用户基本信息(UnionID机制)
public class GetUserInfo {
    public static void main(String[] args) throws Exception{
        Wechat wechat = new WechatFactory().getInstance();
        ResponseUser response = wechat.getUserInfo("oYiqRuKcmIVaKh6BlF7WNFlZA-cs", "");
        if (response.getResponse().getErrCode() == 0){
            System.out.println("Get User Info Succeed." + response);
        } else {
            System.err.println("Get User Info Failed." + response);
        }
    }
}
