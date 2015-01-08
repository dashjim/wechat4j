package com.wisedu.wechat4jv2.auth;

public enum Lang {
    EN("en"),
    ZH_CN("zh_CN"),
    ZH_TW("zh_TW");

    private final String lang;

    private Lang(String lang) {
        this.lang = lang;
    }

    @Override public String toString() {
        return lang;
    }
}
