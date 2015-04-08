# Wechat4J

Wechat4J是一款基于微信公共平台API接口的Java SDK，开发者可用通过这个SDK来开发自己的应用。

## Installation
可以直接使用Maven导入依赖

```
<groupId>com.wisedu.rfocus</groupId>
<artifactId>wechat-java-sdk</artifactId>
<version>1.0.0</version>
```

## Usage
### Configuration
在使用Wechat4J之前，可以在classpath下创建wechat4j.properties文件作为配置文件，开发者可以根据实际情况，做出一些配置。
```
# OAuth
oauth.appId=wxeb08f00467038ff9
oauth.appSecret=f0k581525da6412ef53d2b82766d95c1
```

### Get Instance
首先，开发者需要获取客户端的实例(Wechat4J Client)，才可以调用微信的API。

```
Wechat wechat = new WechatFactory().getInstance();
```
如果已经在wechat.properties文件中对AppId和AppSecret进行了配置，通过上述的方法就可以获取客户端实例了。
如果没有对AppId和AppSecret进行配置，则可以通过下面的方法获取客户端实例。

```
Wechat wechat = new WechatFactory().getInstance(appId, appSecret);
```

### OAuth Support
    enter code here
### Code Sample

## Changelog

## Contributing