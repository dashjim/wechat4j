package com.wisedu.wechat4jv2.auth;

public enum Scope{
    SNSAPI_BASE("snsapi_base"),
    SNSAPI_USERINFO("snsapi_userinfo");

    private final String scope;

    private Scope(String scope) {
        this.scope = scope;
    }

    @Override public String toString(){
        return scope;
    }
}
