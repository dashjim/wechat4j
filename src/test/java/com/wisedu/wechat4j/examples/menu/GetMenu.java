package com.wisedu.wechat4j.examples.menu;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.ResponseMenu;

// 自定义菜单查询接口
public class GetMenu {
    public static void main(String[] args) throws Exception{
        Wechat wechat = new WechatFactory().getInstance();
        ResponseMenu response = wechat.getMenu();
        if (response.getResponse().getErrCode() == 0) {
            System.out.println("Get Menu Succeed." + response);
        } else {
            System.err.println("Get Menu Failed." + response);
        }
    }
}
