package com.wisedu.wechat4j.logging;

import com.wisedu.wechat4j.conf.ConfigurationContext;

public abstract class Logger {
    private static final LoggerFactory LOGGER_FACTORY;
    static {
        LoggerFactory loggerFactory = null;

        String loggerFactoryImpl = ConfigurationContext.getInstance().getLoggerFactory();

        if (loggerFactoryImpl != null) {
            loggerFactory = getLoggerFactoryIfAvailable(loggerFactoryImpl, loggerFactoryImpl);
        }

        // use SLF4J if it's found in the classpath
        if (null == loggerFactory) {
            loggerFactory = getLoggerFactoryIfAvailable("org.slf4j.impl.StaticLoggerBinder", "facebook4j.internal.logging.SLF4JLoggerFactory");
        }

        // otherwise, use commons-logging if it's found in the classpath
        if (null == loggerFactory) {
            loggerFactory = getLoggerFactoryIfAvailable("org.apache.commons.logging.Log", "facebook4j.internal.logging.CommonsLoggingLoggerFactory");
        }

        // otherwise, use log4j if it's found in the classpath
        if (null == loggerFactory) {
            loggerFactory = getLoggerFactoryIfAvailable("org.apache.log4j.Logger", "facebook4j.internal.logging.Log4JLoggerFactory");
        }

        // otherwise, use the default logger
        if (null == loggerFactory) {
            loggerFactory = new StdOutLoggerFactory();
        }

        LOGGER_FACTORY = loggerFactory;
    }

    private static LoggerFactory getLoggerFactoryIfAvailable(String checkClassName, String implementClassName) {
        try {
            Class.forName(checkClassName);
            return  (LoggerFactory)Class.forName(implementClassName).newInstance();
        } catch (ClassNotFoundException cnfe) {
        } catch (InstantiationException ie) {
        } catch (IllegalAccessException iae) {
        }
        return null;
    }

    public static Logger getLogger(Class<?> clazz) {
        return LOGGER_FACTORY.getLogger(clazz);
    }

    public abstract boolean isDebugEnabled();

    public abstract boolean isInfoEnabled();

    public abstract boolean isWarnEnabled();

    public abstract boolean isErrorEnabled();

    public abstract void debug(String message);

    public abstract void debug(String message, String message2);

    public abstract void info(String message);

    public abstract void info(String message, String message2);

    public abstract void warn(String message);

    public abstract void warn(String message, String message2);

    public abstract void error(String message);

    public abstract void error(String message, Throwable th);
}
