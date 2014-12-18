package com.wisedu.wechat4jv2.enity;

import com.wisedu.wechat4jv2.http.HttpResponse;

import java.util.List;

public class ObjectFactory {
    public AccessToken createAccessToken(HttpResponse response) {
        return new AccessToken(response);
    }

    public GroupCollection createGroupCollection(HttpResponse response) {
        return new GroupCollectionJSONImpl(response);
    }

    public UserCollection createUserCollection(HttpResponse response) {
        return new UserCollectionJSONImpl(response);
    }

    public MenuCollection createMenuCollection(HttpResponse response) {
        return new MenuCollectionJSONImpl(response);
    }
}
