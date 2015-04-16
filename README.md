# Wechat4J

Wechat4J是一款基于微信公众平台API接口的Java SDK，开发者可用通过这个SDK来开发自己的应用。

## Installation

开发者可以直接克隆项目，获取最新的源码

    git clone git://github.com/abj351r7/wechat4j

也可以使用Maven，在Pom.xml文件中添加依赖

```

<dependencies>
	<dependency>
		<groupId>com.wisedu.rfocus</groupId>
		<artifactId>wechat-java-sdk</artifactId>
		<version>1.0.0</version>
	</dependency>
	...
</dependencies>
```

## Usage

### Configuration

开发者可以根据实际情况，进行简单配置，只需要将[配置文件(wechat4j.properties)](https://github.com/ABJ351R7/wechat4j/blob/master/src/main/resources/wechat4j.properties)放在classpath根目录下。

```
# OAuth
oauth.appId=wxeb08f00467038ff9
oauth.appSecret=f0k581525da6412ef53d2b82766d95c1
```

否则，使用默认配置。

### Get Instance

开发者需要获得微信客户端的实例(Wechat4J Client Instance)，才可以调用微信公众平台的API。

```
Wechat wechat = new WechatFactory().getInstance();
```
如果已经在[配置文件(wechat4j.properties)](https://github.com/ABJ351R7/wechat4j/blob/master/src/main/resources/wechat4j.properties)中设置了AppId/AppSecret，通过上述的方法就可以获取实例了。

如果没有对AppId/AppSecret进行配置，开发者可以通过下面的方法获取客户端实例。

```
Wechat wechat = new WechatFactory().getInstance(appId, appSecret);
```

### OAuth Support

可以通过下面的方法获取微信的Access Token。

```
ResponseAccessToken token = wechat.getAccessToken();
if (token.getResponse().getErrCode() == 0){
	System.out.println("Get Token Succeed." + token);
} else {
	System.err.println("Get Token Failed." + token);
}
```

对于那些已获取的Access Token，开发者可以将它们保存在缓存中，使用时取出赋给客户端实例。

```
wechat.setAccessToken(credential, expiresIn);
```

### Code Sample

- [获取微信服务器IP地址](https://github.com/ABJ351R7/wechat4j/blob/master/src/test/java/com/wisedu/wechat4j/examples/base/GetCallbackIP.java)

- [客服接口](https://github.com/ABJ351R7/wechat4j/tree/master/src/test/java/com/wisedu/wechat4j/examples/kfAccount)

- [高级群发接口](https://github.com/ABJ351R7/wechat4j/tree/master/src/test/java/com/wisedu/wechat4j/examples/mass)

- [模板消息接口](https://github.com/ABJ351R7/wechat4j/tree/master/src/test/java/com/wisedu/wechat4j/examples/template)

- [分组管理接口](https://github.com/ABJ351R7/wechat4j/tree/master/src/test/java/com/wisedu/wechat4j/examples/group)

- [用户管理接口](https://github.com/ABJ351R7/wechat4j/tree/master/src/test/java/com/wisedu/wechat4j/examples/user)

- [菜单管理接口](https://github.com/ABJ351R7/wechat4j/tree/master/src/test/java/com/wisedu/wechat4j/examples/menu)

- [生成带参数的二维码](https://github.com/ABJ351R7/wechat4j/tree/master/src/test/java/com/wisedu/wechat4j/examples/qrCode)

- [长链接转短链接接口](https://github.com/ABJ351R7/wechat4j/tree/master/src/test/java/com/wisedu/wechat4j/examples/shortURL)

## Further resources

- [微信公众平台 wiki](http://mp.weixin.qq.com/wiki/home/index.html)

## License

Wechat4J 是基于[WTFPL](http://www.wtfpl.net/about/)协议发布的，也就是说，开发者可以“做任何想做的事”。

