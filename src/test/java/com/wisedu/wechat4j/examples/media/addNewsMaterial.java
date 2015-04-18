package com.wisedu.wechat4j.examples.media;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.ResponseMedia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// 新增永久图文素材
public class AddNewsMaterial {
    private static final Map<String, Object> news = new HashMap<String, Object>() {{
        put("articles", new ArrayList<Map<String, Object>>(){{
            add(new HashMap<String, Object>(){{
                put("title", "title");
                put("thumb_media_id", mediaId);
                put("author", "author");
                put("digest", "digest");
                put("show_cover_pic", 0);
                put("content", "content");
                put("content_source_url", "content_source_url");
            }});
        }});
    }};
    private static final String mediaId = "wcZMLMMEISTUX2DvuCjCn4cSLxtHLTPBHWF83FlozJA";

    public static void main(String[] args) throws Exception {
        Wechat wechat = new WechatFactory().getInstance();
        ResponseMedia response = wechat.addNewsMaterial(news);
        if (response.getResponse().getErrCode() == 0){
            System.out.println("Add News Material Succeed." + response);
        } else {
            System.err.println("Add News Material Failed." + response);
        }
    }
}
