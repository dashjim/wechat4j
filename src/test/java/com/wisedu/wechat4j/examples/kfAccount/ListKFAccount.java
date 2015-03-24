package com.wisedu.wechat4j.examples.kfAccount;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.ResponseKFAccountCollection;

public class ListKFAccount {
    public static void main(String[] args) throws Exception{
        Wechat wechat = new WechatFactory().getInstance();
        ResponseKFAccountCollection kfAccountCollection = wechat.listKFAccount();
        if (kfAccountCollection.getResponse().getErrCode() == 0){
            System.out.println("List KfAccount Succeed." + kfAccountCollection);
        } else {
            System.err.println("List KfAccount Failed." + kfAccountCollection);
        }
    }
}
