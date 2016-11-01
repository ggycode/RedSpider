package com.spider.resource.model;

public enum StateEnum {
	init("init"), wait("wait"), query("query"), success("success"), error("error");
    private final String value;

    //������Ĭ��Ҳֻ����private, �Ӷ���֤���캯��ֻ�����ڲ�ʹ��
    StateEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
