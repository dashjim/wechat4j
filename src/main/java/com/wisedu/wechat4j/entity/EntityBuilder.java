package com.wisedu.wechat4j.entity;

public final class EntityBuilder {
    public static TextBuilder TEXT() {
        return new TextBuilder();
    }

    public static MenuBuilder MENU() {
        return new MenuBuilder();
    }
}