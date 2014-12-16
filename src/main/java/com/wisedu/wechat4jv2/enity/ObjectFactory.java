package com.wisedu.wechat4jv2.enity;

import com.wisedu.wechat4jv2.http.HttpResponse;

import java.util.List;

public class ObjectFactory {
    public AccessToken createAccessToken(HttpResponse response) {
        return new AccessToken(response.asJSONObject());
    }

    public List<Group> createGroupList(HttpResponse response) {

    }
}
