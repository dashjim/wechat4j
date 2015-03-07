package com.wisedu.wechat4j.examples.group;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.ResponseGroupCollection;

public class ListGroup {
    public static void main(String[] args) throws Exception {
        Wechat wechat = new WechatFactory().getInstance();
        ResponseGroupCollection collection = wechat.listGroup();
        if (collection.getResponse().getErrCode() == 0){
            System.out.println("List Group Succeed." + collection);
        } else {
            System.err.println("List Group Failed." + collection);
        }
    }
}
