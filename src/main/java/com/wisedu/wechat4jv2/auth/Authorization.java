package com.wisedu.wechat4jv2.auth;

import com.wisedu.wechat4j.internal.http.HttpParameter;

public interface Authorization {
    HttpParameter[] generateAuthorizationParameter();
}
