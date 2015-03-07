package com.wisedu.wechat4j.examples.group;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.ResponseGroup;

import java.io.IOException;
import java.util.HashMap;

public class CreateGroup {
    public static void main(String[] args) throws IOException {
        Wechat wechat = new WechatFactory().getInstance();
        ResponseGroup group = wechat.createGroup(new HashMap<String, Object>());
        if (group.getResponse().getErrCode() == 0){
            System.out.println("List Group Succeed." + group);
        } else {
            System.err.println("List Group Failed." + group);
        }
    }
}
