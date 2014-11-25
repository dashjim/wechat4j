package com.wisedu.wechat4j.auth;

import com.wisedu.wechat4j.conf.AuthorizationConfiguration;
import com.wisedu.wechat4j.internal.http.HttpClient;

public final class AuthorizationFactory {

    public static Authorization getInstance(AuthorizationConfiguration conf, HttpClient http){
        Authorization auth = null;
        String oauthToken = conf.getOAuthToken();
        String oauthAppID = conf.getOAuthAppID();
        String oauthAppSecret = conf.getOAuthAppSecret();
        if (oauthToken!=null && oauthAppID!=null && oauthAppSecret!=null) {
            OAuthAuthorization oauth = new OAuthAuthorization(conf, http);
            oauth.setOAuthApp(oauthToken, oauthAppID, oauthAppSecret);
            String accessToken = conf.getOAuthAccessToken();
            if (accessToken != null){
                oauth.setAccessToken(new AccessToken(accessToken, null));
            }
            auth = oauth;
        } else {
            auth = NullAuthorization.getInstance();
        }
        return auth;
    }
}
