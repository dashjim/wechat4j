package com.wisedu.wechat4jv2.entity;

import com.wisedu.wechat4jv2.http.HttpResponse;

public class ObjectFactory {
    public Response createResponse(HttpResponse response) {
        return new ResponseJSONImpl(response);
    }

    public AccessToken createAccessToken(String credential, Long expiresIn) {
        return new AccessTokenJSONImpl(credential, expiresIn);
    }

    public ResponseAccessToken createResponseAccessToken(HttpResponse response) {
        return new ResponseAccessTokenJSONImpl(response);
    }

    public ResponseMedia createResponseMedia(HttpResponse response) {
        return new ResponseMediaJSONImpl(response);
    }

    public ResponseGroup createResponseGroup(HttpResponse response) {
        return new ResponseGroupJSONImpl(response);
    }

    public ResponseGroupCollection createResponseGroupCollection(HttpResponse response) {
        return new ResponseGroupCollectionJSONImpl(response);
    }

    public ResponseUser createResponseUser(HttpResponse response) {
        return new ResponseUserJSONImpl(response);
    }

    public ResponseUserCollection createResponseUserCollection(HttpResponse response) {
        return new ResponseUserCollectionJSONImpl(response);
    }

    public ResponseMenu createResponseMenu(HttpResponse response) {
        return new ResponseMenuJSONImpl(response);
    }
}
