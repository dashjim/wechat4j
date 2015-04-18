package com.wisedu.wechat4j.examples.media;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.ResponseMedia;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AddViedoMaterial {
    private static final String media = AddViedoMaterial.class.getResource("/").getPath() + "test.flv";
    private static final Map<String, Object> description = new HashMap<String, Object>(){{
        put("title", "1");
        put("introduction","2");
    }};

    public static void main(String[] args) throws Exception {
        Wechat wechat = new WechatFactory().getInstance();
        ResponseMedia response = wechat.addMaterial("video", description, new File(media));
        if (response.getResponse().getErrCode() == 0){
            System.out.println("Add Material Succeed." + response);
        } else {
            System.err.println("Add Material Failed." + response);
        }
    }
}
