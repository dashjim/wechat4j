package com.wisedu.wechat4jv2.enity;

import com.wisedu.wechat4jv2.internal.json.JSONObject;

import java.io.Serializable;

final class GroupJSONImpl implements Group, Serializable {
    private Integer id;
    private String name;
    private Integer count;

    private JSONObject jsonObject;

    GroupJSONImpl(JSONObject jsonObject) {
        init(jsonObject);
    }

    private void init(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
        if (!jsonObject.isNull("id")){
            this.id = jsonObject.getInt("id");
        }
        if (!jsonObject.isNull("groupid")) {
            this.id = jsonObject.getInt("groupid");
        }
        if (!jsonObject.isNull("name")){
            this.name = jsonObject.getString("name");
        }
        if (!jsonObject.isNull("count")){
            this.count = jsonObject.getInt("count");
        }
    }

    @Override public Integer getId() {
        return id;
    }

    @Override public String getName() {
        return name;
    }

    @Override public Integer getCount() {
        return count;
    }

    @Override public JSONObject getObject() {
        return jsonObject;
    }
}
