package com.wisedu.wechat4jv2.entity;

import com.wisedu.wechat4jv2.internal.json.JSONArray;
import com.wisedu.wechat4jv2.internal.json.JSONObject;

import java.io.Serializable;

final class ButtonJSONImpl implements Button, Serializable {
    private String type;
    private String name;
    private String url;
    private String key;
    private Button[] subButon;

    private JSONObject object;

    ButtonJSONImpl(JSONObject jsonObject) {
        init(jsonObject);
    }

    void init(JSONObject jsonObject) {
        this.object = jsonObject;
        if (!jsonObject.isNull("type")) {
            this.type = jsonObject.getString("type");
        }
        if (!jsonObject.isNull("name")) {
            this.name = jsonObject.getString("name");
        }
        if (!jsonObject.isNull("url")) {
            this.url = jsonObject.getString("url");
        }
        if (!jsonObject.isNull("key")) {
            this.key = jsonObject.getString("key");
        }
        if (!jsonObject.isNull("sub_button")) {
            JSONArray array = jsonObject.getJSONArray("sub_button");

            int size = array.length();
            this.subButon = new Button[size];
            for (int i=0; i<size; i++) {
                this.subButon[i] = new ButtonJSONImpl(array.getJSONObject(i));
            }
        }
    }

    @Override public String getType() {
        return type;
    }

    @Override public String getName() {
        return name;
    }

    @Override public String getUrl() {
        return url;
    }

    @Override public String getKey() {
        return key;
    }

    @Override public Button[] getSubButon() {
        return subButon;
    }

    @Override public JSONObject getObject() {
        return object;
    }

    @Override public String toString() {
        return this.object.toString();
    }
}
