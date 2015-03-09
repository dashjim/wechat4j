package com.wisedu.wechat4j.examples.kfAccount;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.Response;

public class ListKFAccount {
    public static void main(String[] args) throws Exception{
        Wechat wechat = new WechatFactory().getInstance();
        Response response = wechat.listKFAccount();
        if (response.getErrCode() == 0){
            System.out.println("List KfAccount Succeed." + response);
        } else {
            System.err.println("List KfAccount Failed." + response);
        }
    }
}
