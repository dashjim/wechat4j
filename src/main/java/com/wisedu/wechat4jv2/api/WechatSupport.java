package com.wisedu.wechat4jv2.api;

import com.wisedu.wechat4jv2.enity.AccessToken;

import java.io.IOException;

public interface WechatSupport {
    void setAuthAccessToken(String accessToken, Long expiresIn);

    AccessToken getAuthAccessToken() throws IOException;
}
