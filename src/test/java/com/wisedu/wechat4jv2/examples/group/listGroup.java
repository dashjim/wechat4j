package com.wisedu.wechat4jv2.examples.group;

import com.wisedu.wechat4jv2.api.Wechat;
import com.wisedu.wechat4jv2.client.WechatFactory;
import com.wisedu.wechat4jv2.entity.ResponseGroupCollection;

import java.io.IOException;

public class listGroup {
    public static void main(String[] args) throws IOException {
        Wechat wechat = new WechatFactory().getInstance();
        ResponseGroupCollection collection = wechat.listGroup();
        if (collection.getResponse().getErrCode() == null){
            System.out.println("List Group Succeed." + collection);
        } else {
            System.err.println("List Group Failed." + collection);
        }
    }
}
