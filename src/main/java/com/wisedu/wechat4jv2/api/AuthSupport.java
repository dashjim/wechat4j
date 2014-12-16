package com.wisedu.wechat4jv2.api;

import com.wisedu.wechat4jv2.enity.AccessToken;

public interface AuthSupport {
    void setAuthApp(String token, String appId, String appSecret);

    AccessToken getAccessToken();

    AccessToken setAccessToken(AccessToken accessToken);
}
