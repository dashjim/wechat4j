package com.wisedu.wechat4j.examples.template;

import com.wisedu.wechat4j.api.Wechat;
import com.wisedu.wechat4j.client.WechatFactory;
import com.wisedu.wechat4j.entity.ResponseMessage;

import java.util.HashMap;
import java.util.Map;

public class SendMessage {
    private static Map<String, Object> template = new HashMap<String, Object>(){{
        put("touser", "oYiqRuKcmIVaKh6BlF7WNFlZA-cs");
        put("template_id", "9kSmmNVQEYHgwdt04AdgAo1Ye4fqPpDH93mWqx0Sm-k");
        put("url", "http://weixin.qq.com/download");
        put("topcolor", "#FF0000");
        put("data", new HashMap<String, Object>(){{
            put("first", new HashMap<String, Object>(){{
                put("value", "恭喜你购买成功！");
                put("color", "#173177");
            }});
            put("keynote1", new HashMap<String, Object>(){{
                put("value", "巧克力");
                put("color", "#173177");
            }});
            put("keynote2", new HashMap<String, Object>(){{
                put("value", "39.8元");
                put("color", "#173177");
            }});
            put("keynote3", new HashMap<String, Object>(){{
                put("value", "2014年9月16日");
                put("color", "#173177");
            }});
            put("remark", new HashMap<String, Object>(){{
                put("value", "欢迎再次购买");
                put("color", "#173177");
            }});
        }});
    }};

    public static void main(String[] args) throws Exception{
        Wechat wechat = new WechatFactory().getInstance();
        ResponseMessage response = wechat.sendTemplateMessage(template);
        if (response.getResponse().getErrCode() == 0) {
            System.out.println("Send Message Succeed." + response);
        } else {
            System.err.println("Send Message Failed." + response);
        }
    }
}
