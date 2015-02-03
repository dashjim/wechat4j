package com.wisedu.wechat4j.examples.kfAccount;

import com.wisedu.wechat4jv2.api.Wechat;
import com.wisedu.wechat4jv2.client.WechatFactory;
import com.wisedu.wechat4jv2.entity.Response;

public class ListKfAccount {
    public static void main(String[] args) throws Exception{
        Wechat wechat = new WechatFactory().getInstance();
        Response response = wechat.listKfAccount();
        if (response.getErrCode() == 0){
            System.out.println("List KfAccount Succeed." + response);
        } else {
            System.err.println("List KfAccount Failed." + response);
        }
    }
}
