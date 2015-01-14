package com.wisedu.wechat4jv2.api;

import com.wisedu.wechat4jv2.entity.Response;
import com.wisedu.wechat4jv2.entity.ResponseGroup;
import com.wisedu.wechat4jv2.entity.ResponseGroupCollection;

import java.io.IOException;
import java.util.Map;

public interface GroupSupport {
    // 创建分组
    ResponseGroup createGroup(Map<String, Object> group) throws IOException;

    // 查询所有分组
    ResponseGroupCollection listGroup() throws IOException;

    // 查询用户所在分组
    ResponseGroupCollection listGroup(Map<String, Object> users);

    // 修改分组名
    Response updateGroup(Map<String, Object> group);

    // 移动用户分组
    Response moveGroup(Map<String, Object> msg);
}
