package com.wisedu.wechat4j.client;

import com.wisedu.wechat4j.WechatException;
import com.wisedu.wechat4j.auth.*;
import com.wisedu.wechat4j.conf.Configuration;
import com.wisedu.wechat4j.entity.AccessToken;
import com.wisedu.wechat4j.entity.JSONImplFactory;
import com.wisedu.wechat4j.entity.ObjectFactory;
import com.wisedu.wechat4j.internal.http.HttpClient;
import com.wisedu.wechat4j.internal.http.HttpClientFactory;


abstract class WechatBaseImpl implements WechatBase, OAuthSupport {
    protected Configuration conf;
    protected Authorization auth;
    protected HttpClient http;
    protected ObjectFactory factory;

    WechatBaseImpl(Configuration conf ){
        this.conf = conf;
        this.http = HttpClientFactory.getInstance(conf);
        this.auth = AuthorizationFactory.getInstance(conf, http);
        this.factory = new JSONImplFactory();
    }

    @Override public void setOAuthApp(String token, String appId, String appSecret){
        if (appId == null){
            throw new NullPointerException("app id is null");
        }
        if (appSecret == null){
            throw new NullPointerException("app secret is null");
        }

        if (auth instanceof NullAuthorization){
            // Authorization oauth = AuthorizationFactory.getInstance(conf, http);
            OAuthAuthorization oauth = new OAuthAuthorization(conf, http);
            oauth.setOAuthApp(token,  appId, appSecret);
            this.auth = oauth;
        } else if (auth instanceof  OAuthAuthorization){
            throw new IllegalStateException("app id/secret pair already set.");
        }
    }

    @Override public void setAccessToken(AccessToken accessToken) {
        getOAuth().setAccessToken(accessToken);
    }

    @Override public AccessToken getAccessToken() throws WechatException{
        return getOAuth().getAccessToken();
    }

    private final OAuthSupport getOAuth(){
        if (!(auth instanceof OAuthSupport)){
            throw new IllegalStateException("OAuth app id/secret combination not supplied");
        }
        return (OAuthSupport)auth;
    }

    protected final void ensureAuthorizationEnabled() throws WechatException{
        if (!auth.isEnabled()){
            throw new WechatException("Ensure authorization enabled failed");
        }
    }

    @Override public final Authorization getAuthorization(){
        return this.auth;
    }

    @Override public final Configuration getConfiguration(){
        return this.conf;
    }
}
