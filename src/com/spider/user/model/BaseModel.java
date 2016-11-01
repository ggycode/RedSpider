package com.spider.user.model;

import java.util.Date;

public class BaseModel {
	private String uuid;
	private Date created = new Date();
	private Date updated;
	private Date removed;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public Date getRemoved() {
		return removed;
	}
	public void setRemoved(Date removed) {
		this.removed = removed;
	}
	
	
}
