package com.wisedu.wechat4j.examples.user;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.ResponseUserCollection;

// 获取用户列表
public class GetUserList {
    public static void main(String[] args) throws Exception{
        Wechat wechat = new WechatFactory().getInstance();
        ResponseUserCollection response = wechat.getUserList(null);
        if (response.getResponse().getErrCode() == 0){
            System.out.println("Get User List Succeed." + response);
        } else {
            System.err.println("Get User List Failed." + response);
        }
    }
}
