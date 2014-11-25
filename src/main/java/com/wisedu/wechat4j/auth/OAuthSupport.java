package com.wisedu.wechat4j.auth;

import com.wisedu.wechat4j.WechatException;

public interface OAuthSupport {
    void setOAuthApp(String token, String appID, String appSecret);

    void setAccessToken(AccessToken accessToken);

    AccessToken getAccessToken() throws WechatException;
}
