package com.wisedu.wechat4j.examples.menu;

import com.wisedu.wechat4j.WechatException;
import com.wisedu.wechat4j.client.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.Menu;
import com.wisedu.wechat4j.entity.Response;

public class GetMenu {
    private static final String oauthToken = "tShow";
    private static final String oauthAppID = "wxeb08f90467938ff7";
    private static final String oauthAppSecret = "504581525da6402ed53d2b82766d95c1";

    public static void main(String[] args) {
        try {
            Wechat wechat = WechatFactory.createWechatInstance();
            wechat.setOAuthApp(oauthToken, oauthAppID, oauthAppSecret);
            Menu menu = wechat.getMenu();
            if (menu.getResponse().getErrCode() == null) {
                System.out.println("Get Menu Succeed: " + menu);
            } else {
                System.err.println("Get Menu failed: " + menu);
            }
        } catch (WechatException we) {
            we.printStackTrace();
        }
    }
}
