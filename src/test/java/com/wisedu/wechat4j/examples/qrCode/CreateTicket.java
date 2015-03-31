package com.wisedu.wechat4j.examples.qrCode;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.ResponseTicket;

import java.util.HashMap;
import java.util.Map;

public class CreateTicket {
    private static Map<String, Object> qr_scene = new HashMap<String, Object>(){{
        put("expire_seconds", 1800);
        put("action_name", "QR_SCENE");
        put("action_info", new HashMap<String, Object>(){{
            put("scene", new HashMap<String, Object>(){{
                put("scene_id", 123);
            }});
        }});
    }};

    private static Map<String, Object> qr_limit_scene = new HashMap<String, Object>(){{
        put("action_name", "QR_LIMIT_SCENE");
        put("action_info", new HashMap<String, Object>(){{
            put("scene", new HashMap<String, Object>(){{
                put("scene_id", 123);
            }});
        }});
    }};

    private static Map<String, Object> qr_limit_str_scene = new HashMap<String, Object>(){{
        put("action_name", "QR_LIMIT_STR_SCENE");
        put("action_info", new HashMap<String, Object>(){{
            put("scene", new HashMap<String, Object>(){{
                put("scene_str", "123");
            }});
        }});
    }};

    public static void main(String[] args) throws Exception{
        Wechat wechat = new WechatFactory().getInstance();
        ResponseTicket response = wechat.createTicket(qr_scene);
        if (response.getResponse().getErrCode() == 0) {
            System.out.println("Create QR Scene Succeed." + response);
        } else {
            System.err.println("Create QR Scene Failed." + response);
        }

        response = wechat.createTicket(qr_limit_scene);
        if (response.getResponse().getErrCode() == 0) {
            System.out.println("Create QR Limit Scene Succeed." + response);
        } else {
            System.err.println("Create QR Limit Scene Failed." + response);
        }

        response = wechat.createTicket(qr_limit_str_scene);
        if (response.getResponse().getErrCode() == 0) {
            System.out.println("Create QR Limit Str Scene Succeed." + response);
        } else {
            System.err.println("Create QR Limit Str Scene Failed." + response);
        }
    }
}
