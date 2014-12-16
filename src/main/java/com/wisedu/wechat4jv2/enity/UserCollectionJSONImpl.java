package com.wisedu.wechat4jv2.enity;

import com.wisedu.wechat4jv2.http.HttpResponse;
import com.wisedu.wechat4jv2.internal.json.JSONObject;

import java.io.Serializable;

final class UserCollectionJSONImpl implements UserCollection, Serializable {

    private User[] users;

    private Response response;

    UserCollectionJSONImpl(HttpResponse response) {
        this(response.asJSONObject());
    }

    UserCollectionJSONImpl(JSONObject jsonObject) {
        init(jsonObject);
    }

    void init(JSONObject jsonObject) {
        this.response = new ResponseJSONImpl(jsonObject);
    }

    @Override public User[] getUsers() {
        return users;
    }

    @Override public Response getResponse() {
        return response;
    }
}
