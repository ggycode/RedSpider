package com.spider.util;

public enum WorkOrderStatus {
	OPENING(0),
	SUCCESS(1),
	FAIL(2);
	
	private Integer value;

	WorkOrderStatus(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
        return this.value;
    }
	
}
