package com.wisedu.wechat4j.client;

import com.wisedu.wechat4j.api.GroupService;
import com.wisedu.wechat4j.api.MenuService;
import com.wisedu.wechat4j.auth.OAuthSupport;

public interface Wechat extends
        GroupService,
        MenuService,
        OAuthSupport {

}
