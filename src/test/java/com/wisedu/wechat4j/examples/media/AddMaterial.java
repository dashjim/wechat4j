package com.wisedu.wechat4j.examples.media;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.ResponseMedia;

import java.io.File;

public class AddMaterial {
    private static final String media = AddMaterial.class.getResource("/").getPath() + "thumb.png";

    public static void main(String[] args) throws Exception {
        Wechat wechat = new WechatFactory().getInstance();
        ResponseMedia response = wechat.addMaterial("thumb", new File(media));
        if (response.getResponse().getErrCode() == 0){
            System.out.println("Add Material Succeed." + response);
        } else {
            System.err.println("Add Material Failed." + response);
        }
    }
}
