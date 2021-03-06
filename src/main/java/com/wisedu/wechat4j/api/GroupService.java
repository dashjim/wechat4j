package com.wisedu.wechat4j.api;

import com.wisedu.wechat4j.entity.Response;
import com.wisedu.wechat4j.entity.ResponseGroup;
import com.wisedu.wechat4j.entity.ResponseGroupCollection;

import java.io.IOException;
import java.util.Map;

public interface GroupService {
    // 创建分组
    ResponseGroup createGroup(Map<String, Object> group) throws IOException;

    // 查询所有分组
    ResponseGroupCollection listGroup() throws IOException;

    // 查询用户所在分组
    ResponseGroup listGroup(Map<String, Object> user) throws IOException;

    // 修改分组名
    Response updateGroup(Map<String, Object> group) throws IOException;

    // 移动用户分组
    Response moveGroup(Map<String, Object> group) throws IOException;

    // 批量移动用户分组
    Response batchMoveGroup(Map<String, Object> group) throws IOException;

    // 删除分组
    Response deleteGroup(Map<String, Object> group) throws IOException;
}
