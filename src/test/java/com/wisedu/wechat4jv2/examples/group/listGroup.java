package com.wisedu.wechat4jv2.examples.group;

import com.wisedu.wechat4jv2.api.Wechat;
import com.wisedu.wechat4jv2.client.WechatFactory;
import com.wisedu.wechat4jv2.entity.ResponseGroupCollection;

import java.io.IOException;

public class listGroup {
    private static final String credential
            = "XPke0AwiC6-CeSWuPsGV8lQcpCXDhilPv0mm-nr79vNSG7ciUZKNuiLCcj3x2CaDUAtq142EgU5F_HQ-73RSgVMNpDZ81B9a6u32sNDtPiE";
    public static void main(String[] args) throws IOException {
        Wechat wechat = new WechatFactory().getInstance();
        wechat.setAccessToken(credential, null);
        ResponseGroupCollection collection = wechat.listGroup();
        if (collection.getResponse().getErrCode() == null){
            System.out.println("List Group Succeed." + collection);
        } else {
            System.err.println("List Group Failed." + collection);
        }
    }
}
