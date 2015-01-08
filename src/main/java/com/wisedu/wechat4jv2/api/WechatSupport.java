package com.wisedu.wechat4jv2.api;

import com.wisedu.wechat4jv2.entity.AccessToken;

import java.io.IOException;

public interface WechatSupport extends
        GroupSupport,
        MenuSupport,
        AuthorizationCodeSupport {
    void setOAuthAppId(String appId, String appSecret);

    void setAuthAppAccessToken(String accessToken, Long expiresIn);

    AccessToken getAuthAppAccessToken() throws IOException;
}
