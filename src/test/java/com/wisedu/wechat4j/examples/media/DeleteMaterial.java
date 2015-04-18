package com.wisedu.wechat4j.examples.media;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.Response;

import java.util.HashMap;
import java.util.Map;

public class DeleteMaterial {
    private static final Map<String, Object> material = new HashMap<String, Object>(){{
        put("media_id", "wcZMLMMEISTUX2DvuCjCn4cSLxtHLTPBHWF83FlozJA");
    }};

    public static void main(String[] args) throws Exception {
        Wechat wechat = new WechatFactory().getInstance();
        Response response = wechat.deleteMaterial(material);
        if (response.getErrCode() == 0){
            System.out.println("Delete Material Succeed." + response);
        } else {
            System.err.println("Delete Material Failed." + response);
        }
    }
}
