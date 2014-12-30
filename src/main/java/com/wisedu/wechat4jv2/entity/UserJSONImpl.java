package com.wisedu.wechat4jv2.entity;

import com.wisedu.wechat4jv2.internal.json.JSONArray;
import com.wisedu.wechat4jv2.internal.json.JSONObject;

import java.io.Serializable;

final class UserJSONImpl implements User, Serializable {
    private Integer subscribe;
    private String openId;
    private String nickname;
    private Integer sex;
    private String language;
    private String city;
    private String province;
    private String country;
    private String headImgURL;
    private Long subscribeTime;
    private String unionId;
    private String[] privilege;

    private JSONObject object;

    UserJSONImpl(String openId) {
        this.openId = openId;
        this.object = new JSONObject(
                "{\"openid\": \"" + openId + "\"}"
        );
    }

    UserJSONImpl(JSONObject jsonObject) {
        init(jsonObject);
    }

    void init(JSONObject jsonObject) {
        this.object = jsonObject;
        if (!jsonObject.isNull("subscribe")) {
            this.subscribe = jsonObject.getInt("subscribe");
        }
        if (!jsonObject.isNull("openid")) {
            this.openId = jsonObject.getString("openid");
        }
        if (!jsonObject.isNull("nickname")){
            this.nickname = jsonObject.getString("nickname");
        }
        if (!jsonObject.isNull("sex")) {
            this.sex = jsonObject.getInt("sex");
        }
        if (!jsonObject.isNull("language")){
            this.language = jsonObject.getString("language");
        }
        if (!jsonObject.isNull("city")){
            this.city = jsonObject.getString("city");
        }
        if (!jsonObject.isNull("province")) {
            this.province = jsonObject.getString("province");
        }
        if (!jsonObject.isNull("country")){
            this.country = jsonObject.getString("country");
        }
        if (!jsonObject.isNull("headimgurl")){
            this.headImgURL = jsonObject.getString("headimgurl");
        }
        if (!jsonObject.isNull("subscribe_time")) {
            this.subscribeTime = jsonObject.getLong("subscribe_time");
        }
        if (!jsonObject.isNull("privilege")) {
            JSONArray array = jsonObject.getJSONArray("privilege");

            int size = array.length();
            this.privilege = new String[size];
            for (int i=0; i<size; i++) {
                this.privilege[i] = array.getString(i);
            }
        }
        if (!jsonObject.isNull("unionid")) {
            this.unionId = jsonObject.getString("unionid");
        }
    }

    @Override public Integer getSubscribe() {
        return subscribe;
    }

    @Override public String getOpenId() {
        return openId;
    }

    @Override public String getNickname() {
        return nickname;
    }

    @Override public Integer getSex() {
        return sex;
    }

    @Override public String getLanguage() {
        return language;
    }

    @Override public String getCity() {
        return city;
    }

    @Override public String getProvince() {
        return province;
    }

    @Override public String getCountry() {
        return country;
    }

    @Override public String getHeadImgURL() {
        return headImgURL;
    }

    @Override public Long getSubscribeTime() {
        return subscribeTime;
    }

    @Override public String[] getPrivilege() {
        return privilege;
    }

    @Override public String getUnionId() {
        return unionId;
    }

    @Override public String toString() {
        return object.toString();
    }
}
