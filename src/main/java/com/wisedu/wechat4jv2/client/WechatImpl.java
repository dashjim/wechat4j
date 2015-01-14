package com.wisedu.wechat4jv2.client;

import com.wisedu.wechat4j.internal.json.JSONObject;
import com.wisedu.wechat4jv2.api.Wechat;
import com.wisedu.wechat4jv2.conf.Configuration;
import com.wisedu.wechat4jv2.entity.*;
import com.wisedu.wechat4jv2.http.HttpClient;
import com.wisedu.wechat4jv2.http.HttpClientFactory;
import com.wisedu.wechat4jv2.http.HttpParameter;
import com.wisedu.wechat4jv2.http.HttpResponse;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

final class WechatImpl implements Wechat, Serializable {
    private static final long serialVersionUID = 8970456419937426235L;

    private Configuration conf;
    private HttpClient http;
    private ObjectFactory factory;

    private AccessToken accessToken;

    WechatImpl(Configuration conf) {
        this.conf = conf;
        init(conf);
    }

    private void init(Configuration conf) {
        setHttp();
        setFactory();
    }

    private void setHttp() {
        this.http = HttpClientFactory.getInstance(conf);
    }

    private void setFactory() {
        this.factory = new ObjectFactory();
    }

    private HttpResponse get(String url, HttpParameter[] params) throws IOException {
        return http.get(url, params);
    }

    private HttpResponse post(String url, HttpParameter[] params) throws IOException{
        return http.post(url, params);
    }

    @Override public ResponseAccessToken getAccessToken() throws IOException{
        String url = conf.getRestBaseURL();
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter("appid", conf.getAuthAppId()),
                new HttpParameter("secret", conf.getAuthAppSecret())
        };
        ResponseAccessToken responseAccessToken
                = factory.createResponseAccessToken(get(url, params));
        this.accessToken = responseAccessToken.getAccessToken();
        return responseAccessToken;
    }

    @Override public void setAccessToken(String credential, Long expiresIn) {
        this.accessToken = factory.createAccessToken(credential, expiresIn);
    }

    @Override public ResponseGroup createGroup(Map<String, Object> group) throws IOException{
        String url = conf.getRestBaseURL();
        HttpParameter[] params = new HttpParameter[] {
                new HttpParameter(new JSONObject(group))
        };
        return factory.createResponseGroup(post(url, params));
    }

    @Override public ResponseGroupCollection listGroup() {
        return null;
    }

    @Override public ResponseGroupCollection listGroup(Map<String, Object> users) {
        return null;
    }

    @Override public Response updateGroup(Map<String, Object> group) {
        return null;
    }

    @Override public Response moveGroup(Map<String, Object> msg) {
        return null;
    }
}
