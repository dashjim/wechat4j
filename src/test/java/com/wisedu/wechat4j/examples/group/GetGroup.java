package com.wisedu.wechat4j.examples.group;

import com.wisedu.wechat4j.WechatException;
import com.wisedu.wechat4j.auth.AccessToken;
import com.wisedu.wechat4j.client.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.Contact;

public class GetGroup {
    private static final String oauthToken = "tShow";
    private static final String oauthAppID = "wxeb08f90467938ff7";
    private static final String oauthAppSecret = "504581525da6402ed53d2b82766d95c1";

    public static void main(String[] args) {
        try {
            Wechat wechat = WechatFactory.createWechatInstance();
            wechat.setOAuthApp(oauthToken, oauthAppID, oauthAppSecret);
            Contact contact = wechat.getContact();
            if (contact.getResponse().getErrCode() == null) {
                System.out.println("Get Contact Succeed: " + contact);
            } else {
                System.err.println("Get Contact failed: " + contact);
            }
        } catch (WechatException we) {
            we.printStackTrace();
        }
    }
}
