package com.wisedu.wechat4j.examples.menu;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// 自定义菜单创建接口
public class CreateMenu {
    private static Map<String, Object> menu = new HashMap<String, Object>(){{
        put("button", new ArrayList<Map<String, Object>>(){{
            add(new HashMap<String, Object>(){{
                put("type", "click");
                put("name", "今日歌曲");
                put("key", "V1001_TODAY_MUSIC");
            }});
            add(new HashMap<String, Object>(){{
                put("name", "菜单");
                put("sub_button", new ArrayList<Map<String, Object>>(){{
                    add(new HashMap<String, Object>(){{
                        put("type", "view");
                        put("name", "搜索");
                        put("url", "http://www.soso.com/");
                    }});
                    add(new HashMap<String, Object>(){{
                        put("type", "view");
                        put("name", "视频");
                        put("url", "http://v.qq.com/");
                    }});
                    add(new HashMap<String, Object>(){{
                        put("type", "click");
                        put("name", "赞一下我们");
                        put("key", "V1001_GOOD");
                    }});
                }});
            }});
            add(new HashMap<String, Object>(){{
                put("name", "发送位置");
                put("type", "location_select");
                put("key", "rselfmenu_2_0");
            }});
        }});
    }};

    public static void main(String[] args) throws Exception{
        Wechat wechat = new WechatFactory().getInstance();
        Response response = wechat.createMenu(menu);
        if (response.getErrCode() == 0) {
            System.out.println("Create Menu Succeed." + response);
        } else {
            System.err.println("Create Menu Failed." + response);
        }
    }
}
