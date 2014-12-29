package com.wisedu.wechat4jv2.auth;

import com.wisedu.wechat4jv2.entity.AccessToken;

import java.io.IOException;

public interface AuthSupport extends Authorization {
    void setOAuthAppId(String appId, String appSecret);

    void setAuthAppAccessToken(String accessToken, Long expiresIn);

    AccessToken getAuthAppAccessToken() throws IOException;
}
