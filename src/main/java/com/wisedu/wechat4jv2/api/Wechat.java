package com.wisedu.wechat4jv2.api;

import com.wisedu.wechat4jv2.entity.ResponseAccessToken;

import java.io.IOException;

public interface Wechat extends
        MediaService,
        KfAccountService,
        GroupService,
        MenuSerice,
        OAuth2Service {
    void setAccessToken(String credential, Long expiresIn);

    // 获取Access Token
    ResponseAccessToken getAccessToken() throws IOException;
}
