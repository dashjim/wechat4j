package com.wisedu.wechat4jv2.enity;

import com.wisedu.wechat4jv2.internal.json.JSONObject;

public interface Group {
    Integer getId();

    String getName() ;

    Integer getCount();

    JSONObject getObject() ;
}