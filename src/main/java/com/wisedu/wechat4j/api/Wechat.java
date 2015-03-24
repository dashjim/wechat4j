package com.wisedu.wechat4j.api;

import com.wisedu.wechat4j.entity.ResponseAccessToken;

import java.io.IOException;

public interface Wechat extends
        MediaService,
        KFAccountService,
        GroupService,
        MenuSerice,
        OAuth2Service {
    void setAccessToken(String credential, Long expiresIn);

    // 获取Access Token
    ResponseAccessToken getAccessToken() throws IOException;
}