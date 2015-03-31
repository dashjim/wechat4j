package com.wisedu.wechat4j.examples.menu;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.Response;

public class DeleteMenu {
    public static void main(String[] args) throws Exception{
        Wechat wechat = new WechatFactory().getInstance();
        Response response = wechat.deleteMenu();
        if (response.getErrCode() == 0) {
            System.out.println("Delete Menu Succeed." + response);
        } else {
            System.err.println("Delete Menu Failed." + response);
        }
    }
}
