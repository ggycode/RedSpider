package com.spider.resource.model;

public enum StateEnum {
	init("init"), wait("wait"), query("query"), success("success"), error("error");
    private final String value;

    //构造器默认也只能是private, 从而保证构造函数只能在内部使用
    StateEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
