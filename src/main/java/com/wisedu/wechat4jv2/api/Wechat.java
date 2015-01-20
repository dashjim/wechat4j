package com.wisedu.wechat4jv2.api;

import com.wisedu.wechat4jv2.entity.ResponseAccessToken;

import java.io.IOException;

public interface Wechat extends
        MediaService,
        GroupService,
        MenuSerice {
    ResponseAccessToken getAccessToken() throws IOException;

    void setAccessToken(String credential, Long expiresIn);
}
