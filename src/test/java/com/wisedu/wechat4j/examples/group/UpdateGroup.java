package com.wisedu.wechat4j.examples.group;

import com.wisedu.wechat4j.WechatException;
import com.wisedu.wechat4j.client.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.Response;
import com.wisedu.wechat4j.internal.json.JSONObject;

public class UpdateGroup {
    private static final String oauthToken = "tShow";
    private static final String oauthAppID = "wxeb08f90467938ff7";
    private static final String oauthAppSecret = "504581525da6402ed53d2b82766d95c1";

    public static void main(String[] args) {
        try {
            Wechat wechat = WechatFactory.createWechatInstance();
            wechat.setOAuthApp(oauthToken, oauthAppID, oauthAppSecret);
            Response response = wechat.updateContact(new JSONObject("{\"group\":{\"id\":101,\"name\":\"test2_modify2\"}}"));
            if (response.getErrCode() == 0) {
                System.out.println("Update Contact Succeed: " + response);
            } else {
                System.err.println("Update Contact Failed: " + response);
            }
        } catch (WechatException we) {
            we.printStackTrace();
        }
    }
}
