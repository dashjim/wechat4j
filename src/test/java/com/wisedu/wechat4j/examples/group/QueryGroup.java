package com.wisedu.wechat4j.examples.group;

import com.wisedu.wechat4j.WechatException;
import com.wisedu.wechat4j.client.Wechat;
import com.wisedu.wechat4j.entity.Contact;
import com.wisedu.wechat4j.internal.json.JSONObject;

public class QueryGroup {
    public static void main(String[] args) {
        try {
            Wechat wechat = Wechat.newInstance();
            Contact contact = wechat.queryContact(new JSONObject("{\"openid\":\"oYiqRuKcmIVaKh6BlF7WNFlZA-cs\"}"));
            if (contact.getResponse().getErrCode() == null) {
                System.out.println("Query Group Succeed: " + contact);
            } else {
                System.err.println("Query Group Failed: " + contact);
            }
        } catch (WechatException we) {
            we.printStackTrace();
        }
    }
}
