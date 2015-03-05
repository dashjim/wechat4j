package com.wisedu.wechat4jv2.internal.logger;

final class StdOutLoggerFactory extends LoggerFactory{
    private static final Logger SIGLETON = new StdOutLogger();

    @Override
    public Logger getLogger(Class<?> clazz) {
        return SIGLETON;
    }
}
