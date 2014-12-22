package com.wisedu.wechat4jv2.auth;

import com.wisedu.wechat4jv2.auth.AuthSupport;
import com.wisedu.wechat4jv2.auth.Authorization;

import java.lang.String;

final class AuthSupportImpl implements AuthSupport, Serializable {
    private String appId;
    private String appSecret;
    private AccessToken clientCredentials;
}
