package com.wisedu.wechat4j.api;

import com.wisedu.wechat4j.entity.Response;
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
}