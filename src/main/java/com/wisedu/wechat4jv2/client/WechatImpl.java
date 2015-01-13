package com.wisedu.wechat4jv2.client;

import com.wisedu.wechat4jv2.api.Wechat;
import com.wisedu.wechat4jv2.conf.Configuration;
import com.wisedu.wechat4jv2.entity.ObjectFactory;
import com.wisedu.wechat4jv2.entity.Response;
import com.wisedu.wechat4jv2.entity.ResponseGroup;
import com.wisedu.wechat4jv2.entity.ResponseGroupCollection;
import com.wisedu.wechat4jv2.http.HttpClient;
import com.wisedu.wechat4jv2.http.HttpClientFactory;
import com.wisedu.wechat4jv2.http.HttpParameter;
import com.wisedu.wechat4jv2.http.HttpResponse;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

final class WechatImpl implements Wechat, Serializable {
    private Configuration conf;
    private HttpClient http;
    private ObjectFactory factory;

    WechatImpl(Configuration conf) {
        init(conf);
    }

    private void init(Configuration conf) {
        this.conf = conf;
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

    @Override public ResponseGroup createGroup(Map<String, Object> group) {
        return null;
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
