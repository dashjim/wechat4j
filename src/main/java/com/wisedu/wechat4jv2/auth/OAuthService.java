package com.wisedu.wechat4jv2.auth;

import com.wisedu.wechat4jv2.entity.ResponseAccessToken;

import java.io.IOException;

public interface OAuthService {
    ResponseAccessToken getAccessToken() throws IOException;
}