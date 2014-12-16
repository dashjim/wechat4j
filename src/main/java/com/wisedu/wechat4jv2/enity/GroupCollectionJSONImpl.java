package com.wisedu.wechat4jv2.enity;

import com.wisedu.wechat4jv2.http.HttpResponse;
import com.wisedu.wechat4jv2.internal.json.JSONArray;
import com.wisedu.wechat4jv2.internal.json.JSONObject;

import java.io.Serializable;

final class GroupCollectionJSONImpl implements GroupCollection,  Serializable {

    private Group[] groups;

    private Response response;

    GroupCollectionJSONImpl(HttpResponse response) {
        this(response.asJSONObject());
    }

    GroupCollectionJSONImpl(JSONObject jsonObject) {
        init(jsonObject);
    }

    void init(JSONObject jsonObject) {
        this.response = new ResponseJSONImpl(jsonObject);
        if (!jsonObject.isNull("groups")) {
            JSONArray array = jsonObject.getJSONArray("groups");

            int size = array.length();
            groups = new Group[size];
            for (int i=0; i<size; i++){
                groups[i] = new GroupJSONImpl(array.getJSONObject(i));
            }
        } else if (!jsonObject.isNull("group")) {
            groups = new Group[] {
                    new GroupJSONImpl(jsonObject)
            };
        } else if (!jsonObject.isNull("groupid")) {
            groups = new Group[] {
                    new GroupJSONImpl(jsonObject)
            };
        } else {
            groups = new Group[] {};
        }
    }

    @Override public Group[] getGroups() {
        return groups;
    }

    @Override public Response getResponse() {
        return response;
    }
}
