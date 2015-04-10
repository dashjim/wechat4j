package com.wisedu.wechat4j.logging;

public class StdOutLoggerFactory extends LoggerFactory{
    private static final Logger SINGLETON = new StdOutLogger();

    @Override public Logger getLogger(Class clazz) {
        return SINGLETON;
    }
}
