package com.wisedu.wechat4jv2.conf;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

class ConfigurationBase implements Configuration, Serializable {
    private static final long serialVersionUID = -6692513626308299468L;
    private boolean gzipEnabled;
    private String loggerFactory;

    private String authToken;
    private String authAppId;
    private String authAppSecret;
    private String authAccessToken;

    private int httpRetryCount;
    private int httpReadTimeout;
    private int httpConnectionTimeout;
    private int httpRetryIntervalSeconds;
    private int httpMaxTotalConnections;

    private Map<String, String> requestHeaders;
    private String restBaseURL = "https://api.weixin.qq.com/cgi-bin";
    private String tokenURL = "https://api.weixin.qq.com/cgi-bin/token";

    protected ConfigurationBase(){
        setGZIPEnabled(true);
        setLoggerFactory(null);

        setAuthToken(null);
        setAuthAppID(null);
        setAuthAppSecret(null);

        setHttpRetryCount(0);
        setHttpReadTimeout(10000);
        setHttpConnectionTimeout(10000);
        setHttpRetryIntervalSeconds(5);
        setHttpMaxTotalConnections(20);
    }

    @Override public final boolean isGZIPEnabled(){
        return gzipEnabled;
    }

    protected final void setGZIPEnabled(boolean gzipEnabled){
        this.gzipEnabled = gzipEnabled;
        initRequestHeaders();
    }

    private void initRequestHeaders(){
        requestHeaders = new HashMap<String, String>();
        if (isGZIPEnabled()){
            requestHeaders.put("Accept-Encoding", "gzip");
        }
    }

    public final Map<String, String> getRequestHeaders(){
        return requestHeaders;
    }

    @Override public final String getLoggerFactory(){
        return loggerFactory;
    }

    protected final void setLoggerFactory(String loggerFactory){
        this.loggerFactory = loggerFactory;
    }

    @Override public final String getAuthToken(){
        return authToken;
    }

    protected final void setAuthToken(String oAuthToken){
        this.authToken = oAuthToken;
    }

    @Override public final String getAuthAppID(){
        return authAppId;
    }

    protected final void setAuthAppID(String oAuthToken){
        this.authAppId = oAuthToken;
    }

    @Override public final String getAuthAppSecret(){
        return authAppSecret;
    }

    protected final void setAuthAppSecret(String oAuthAppSecret){
        this.authAppSecret = oAuthAppSecret;
    }

    @Override public final String getAuthAccessToken() {
        return authAccessToken;
    }

    protected final void setAuthAccessToken(String oAuthAccessToken) {
        this.authAccessToken = oAuthAccessToken;
    }

    @Override public final int getHttpRetryCount(){
        return httpRetryCount;
    }

    protected final void setHttpRetryCount(int httpRetryCount){
        this.httpRetryCount = httpRetryCount;
    }

    @Override public final int getHttpReadTimeout(){
        return httpReadTimeout;
    }

    protected final void setHttpReadTimeout(int httpReadTimeout){
        this.httpReadTimeout = httpReadTimeout;
    }

    @Override public final int getHttpConnectionTimeout(){
        return httpConnectionTimeout;
    }

    protected final void setHttpConnectionTimeout(int httpConnectionTimeout){
        this.httpConnectionTimeout = httpConnectionTimeout;
    }

    @Override public final int getHttpRetryIntervalSeconds(){
        return httpRetryIntervalSeconds;
    }

    protected final void setHttpRetryIntervalSeconds(int httpRetryIntervalSeconds){
        this.httpRetryIntervalSeconds = httpRetryIntervalSeconds;
    }

    @Override public final int getHttpMaxTotalConnections(){
        return httpMaxTotalConnections;
    }

    protected final void setHttpMaxTotalConnections(int httpMaxTotalConnections){
        this.httpMaxTotalConnections = httpMaxTotalConnections;
    }

    @Override public String getRestBaseURL() {
        return restBaseURL;
    }

    protected final void setRestBaseURL(String restBaseURL) {
        this.restBaseURL = restBaseURL;
    }

    @Override public String getTokenURL() {
        return tokenURL;
    }

    protected final void setTokenURL(String tokenURL) {
        this.tokenURL = tokenURL;
    }
}