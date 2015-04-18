package com.wisedu.wechat4j.examples.group;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.ResponseGroupCollection;

// 查询所有分组
public class ListGroup {
    public static void main(String[] args) throws Exception {
        Wechat wechat = new WechatFactory().getInstance();
        ResponseGroupCollection response = wechat.listGroup();
        if (response.getResponse().getErrCode() == 0){
            System.out.println("List Group Succeed." + response);
        } else {
            System.err.println("List Group Failed." + response);
        }
    }
}
