package com.spider.resource.model;

import com.spider.user.model.BaseModel;

public class BusinessResourceRelation extends BaseModel{
	private String userId;
	private String businessResId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBusinessResId() {
		return businessResId;
	}
	public void setBusinessResId(String businessResId) {
		this.businessResId = businessResId;
	}
}
