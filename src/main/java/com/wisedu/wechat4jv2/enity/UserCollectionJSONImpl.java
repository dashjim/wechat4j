package com.wisedu.wechat4jv2.enity;

import com.wisedu.wechat4jv2.http.HttpResponse;
import com.wisedu.wechat4jv2.internal.json.JSONArray;
import com.wisedu.wechat4jv2.internal.json.JSONObject;

import java.io.Serializable;

final class UserCollectionJSONImpl implements UserCollection, Serializable {
    private Integer total;
    private Integer count;
    private Integer next_openid;
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
        if (!jsonObject.isNull("data")) {
            if (!jsonObject.isNull("total")) {
                this.total = jsonObject.getInt("total");
            }
            if (jsonObject.isNull("count")) {
                this.count = jsonObject.getInt("count");
            }
            if (!jsonObject.isNull("data")) {
                JSONObject data = jsonObject.getJSONObject("data");
                if (!data.isNull("openid")) {
                    JSONArray array = jsonObject.getJSONArray("openid");

                    int size = array.length();
                    this.users = new User[size];
                    for (int i=0; i<size; i++){
                        this.users[i] = new UserJSONImpl(array.getString(i));
                    }
                }
            }
            if (!jsonObject.isNull("next_openid")) {
                this.next_openid = jsonObject.getInt("next_openid");
            }
        } else if (!jsonObject.isNull("openid")) {
            users = new User[] {
                    new UserJSONImpl(jsonObject)
            };
        } else {
            users = new User[]{};
        }
    }

    @Override public Integer getTotal() {
        return total;
    }

    @Override public Integer getCount() {
        return count;
    }

    @Override public Integer getNext_openid() {
        return next_openid;
    }

    @Override public User[] getUsers() {
        return users;
    }

    @Override public Response getResponse() {
        return response;
    }

    @Override public String toString() {
        return response.toString();
    }
}
