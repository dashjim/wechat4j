package com.wisedu.wechat4j.examples.mass;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.ResponseUploadNews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UploadNews {
    private static Map<String, Object> news = new HashMap<String, Object>() {{
        put("articles", new ArrayList<Map<String, Object>>() {{
            add(new HashMap<String, Object>(){{
                put("thumb_media_id", "CXU-f-Zutt09-pHBVt2E5QhcIICo5dbU2m7Lian2FgH6C_7W_cgompK8_d2Nwq0g");
                put("author", "xxx");
                put("title", "Happy Day");
                put("content_source_url", "www.qq.com");
                put("content", "content");
                put("digest", "digest");
                put("show_cover_pic", "1");
            }});
            add(new HashMap<String, Object>(){{
                put("thumb_media_id", "CXU-f-Zutt09-pHBVt2E5QhcIICo5dbU2m7Lian2FgH6C_7W_cgompK8_d2Nwq0g");
                put("author", "xxx");
                put("title", "Happy Day");
                put("content_source_url", "www.qq.com");
                put("content", "content");
                put("digest", "digest");
                put("show_cover_pic", "0");
            }});
        }});
    }};

    public static void main(String[] args) throws Exception {
        Wechat wechat = new WechatFactory().getInstance();
        ResponseUploadNews responseUploadNews = wechat.uploadNews(news);
        if (responseUploadNews.getResponse().getErrCode() == 0) {
            System.out.println("Upload News Succeed." + responseUploadNews);
        } else {
            System.err.println("Upload News Failed." + responseUploadNews);
        }
    }
}
