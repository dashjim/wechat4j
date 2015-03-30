package com.wisedu.wechat4j.api;

import com.wisedu.wechat4j.entity.Response;
import com.wisedu.wechat4j.entity.ResponseOAuth2AccessToken;
import com.wisedu.wechat4j.entity.ResponseUser;
import com.wisedu.wechat4j.entity.ResponseUserCollection;

import java.io.IOException;
import java.util.Map;

public interface UserService {
    // 设置备注名
    Response updateRemark(Map<String, Object> remark) throws IOException;

    // 获取用户基本信息（包括UnionID机制）
    ResponseUser getUserInfo(String openId, String lang) throws IOException;

    // 获取用户列表
    ResponseUserCollection getUserList(String nextOpenId) throws IOException;

    // 生成授权链接
    String generateOAuth2URL(String redirectURI, String scope, String state) throws IOException;

    // 通过code换取网页授权access_token
    ResponseOAuth2AccessToken getOAuth2AccessToken(String code) throws IOException;
}