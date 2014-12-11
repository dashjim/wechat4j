package com.wisedu.wechat4jv2.api;

import com.wisedu.wechat4jv2.enity.AccessToken;

import java.io.IOException;

public interface WechatSupport {
    void setAccessToken(String accessToken, Long expiresIn);

    AccessToken getAccessToken() throws IOException;
}
