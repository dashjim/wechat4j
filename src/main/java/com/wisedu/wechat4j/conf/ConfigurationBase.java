package com.wisedu.wechat4j.conf;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

class ConfigurationBase implements Configuration, Serializable {
    private static final long serialVersionUID = -6692513626308299468L;
    private boolean debugEnabled;
    private boolean gzipEnabled;
    private String loggerFactory;

    private String oauthAppId;
    private String oauthAppSecret;
    private String oauthAppCredential;

    private int httpRetryCount;
    private int httpReadTimeout;
    private int httpConnectionTimeout;
    private int httpRetryIntervalSeconds;
    private int httpMaxTotalConnections;

    private Map<String, String> requestHeaders;
    private String restBaseURL = "https://api.weixin.qq.com";
    private String mediaBaseURL = "http://file.api.weixin.qq.com";

    protected ConfigurationBase(){
        setDebugEnabled(false);
        setGZIPEnabled(true);
        setLoggerFactory(null);

        setOAuthAppId(null);
        setOAuthAppSecret(null);

        setHttpRetryCount(0);
        setHttpReadTimeout(10000);
        setHttpConnectionTimeout(10000);
        setHttpRetryIntervalSeconds(5);
        setHttpMaxTotalConnections(20);
    }

    @Override public final boolean isDebugEnabled() {
        return debugEnabled;
    }

    protected final void setDebugEnabled(boolean debugEnabled) {
        this.debugEnabled = debugEnabled;
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

    @Override public final String getOAuthAppId(){
        return oauthAppId;
    }

    protected final void setOAuthAppId(String oauthAppId){
        this.oauthAppId = oauthAppId;
    }

    @Override public final String getOAuthAppSecret(){
        return oauthAppSecret;
    }

    protected final void setOAuthAppSecret(String oauthAppSecret){
        this.oauthAppSecret = oauthAppSecret;
    }

    @Override public final String getOAuthAppCredential(){
        return oauthAppCredential;
    }

    protected final void setOAuthAppCredential(String oauthAppCredential){
        this.oauthAppCredential = oauthAppCredential;
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

    @Override public String getMediaBaseURL() {
        return mediaBaseURL;
    }

    protected final void setMediaBaseURL(String mediaBaseURL) {
        this.mediaBaseURL = mediaBaseURL;
    }
}