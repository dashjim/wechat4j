package com.wisedu.wechat4jv2.api;

import com.wisedu.wechat4jv2.enity.AccessToken;

import java.io.IOException;

public interface WechatSupport
        extends GroupSupport, MenuSupport{
    void setOAuthAppId(String appId, String appSecret);

    void setAuthAppAccessToken(String accessToken, Long expiresIn);

    AccessToken getAuthAppAccessToken() throws IOException;
}
