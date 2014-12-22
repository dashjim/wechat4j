package com.wisedu.wechat4jv2.auth;

import com.wisedu.wechat4jv2.enity.AccessToken;

public interface AuthSupport extends Authorization {
    String getToken();

    String getAppId();

    String getAppSecret();

    AccessToken getAccessToken();

    String setAccessToken(AccessToken accessToken);
}
