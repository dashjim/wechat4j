package com.wisedu.wechat4jv2.enity;

import com.wisedu.wechat4jv2.http.HttpResponse;

public class ObjectFactory {
    public AccessToken createAccessToken(HttpResponse response) {
        return new AccessToken(response.asJSONObject());
    }
}
