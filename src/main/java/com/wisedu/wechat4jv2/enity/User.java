package com.wisedu.wechat4jv2.enity;

import com.wisedu.wechat4jv2.internal.json.JSONObject;

public interface User {
    Integer getSubscribe();

    String getOpenid() ;

    String getNickname();

    Integer getSex();

    String getLanguage();

    String getCity();

    String getProvince();

    String getCountry();

    String getHeadimgurl();

    Long getSubscribe_time();

    String[] getPrivilege();

    String getUnionid();

    JSONObject getObject();
}
