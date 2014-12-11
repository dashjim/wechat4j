package com.wisedu.wechat4jv2.conf;

public final class ConfigurationContext {
    private final static PropertyConfiguration ROOT_CONFIGURATION;

    static {
        ROOT_CONFIGURATION = new PropertyConfiguration();
    }

    public static Configuration getInstance(){
        return ROOT_CONFIGURATION;
    }
}
