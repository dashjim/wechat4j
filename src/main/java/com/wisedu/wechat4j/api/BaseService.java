package com.wisedu.wechat4j.api;

import com.wisedu.wechat4j.entity.ResponseAccessToken;
import com.wisedu.wechat4j.entity.ResponseCallbackIP;

import java.io.IOException;

public interface BaseService {
    // 获取Access Token
    ResponseAccessToken getAccessToken() throws IOException;

    // 获取微信服务器IP地址
    ResponseCallbackIP getCallbackIP() throws IOException;
}
