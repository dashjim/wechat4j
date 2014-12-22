package com.wisedu.wechat4jv2.enity;

import com.wisedu.wechat4jv2.http.HttpResponse;

public class ObjectFactory {
    public AccessToken createAccessToken(HttpResponse response) {
        return null;
    }

    public AccessToken createAccessToken(String credential, Long expiresIn) {
        return new AccessTokenJSONImpl(credential, expiresIn);
    }

    public AccessTokenWarpper createAccessTokenWarpper(HttpResponse response) {
        return new AccessTokenWarpperJSONImpl(response);
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
