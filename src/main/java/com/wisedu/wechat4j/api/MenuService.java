package com.wisedu.wechat4j.api;

import com.wisedu.wechat4j.entity.Response;
import com.wisedu.wechat4j.entity.ResponseMenu;

import java.io.IOException;
import java.util.Map;

public interface MenuService {
    // 自定义菜单创建接口
    Response createMenu(Map<String, Object> menu) throws IOException;

    // 自定义菜单查询接口
    ResponseMenu getMenu() throws IOException;

    // 自定义菜单删除接口
    Response deleteMenu() throws IOException;
}
