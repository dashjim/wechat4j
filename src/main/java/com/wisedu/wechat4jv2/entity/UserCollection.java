package com.wisedu.wechat4jv2.entity;

public interface UserCollection {
    Integer getTotal() ;

    Integer getCount();

    Integer getNext_openid();

    User[] getUsers();

    Response getResponse();
}
