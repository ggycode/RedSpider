package com.spider.resource.model;

public class Platform {
	private String id;
	private String name;
	private String platformTypeId;
	private String url;
	private Integer port;
	private String authInfo;
	private String description;
	private String platformGroupName;
	private String platformTypeClass;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlatformTypeId() {
		return platformTypeId;
	}
	public void setPlatformTypeId(String platformTypeId) {
		this.platformTypeId = platformTypeId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public String getAuthInfo() {
		return authInfo;
	}
	public void setAuthInfo(String authInfo) {
		this.authInfo = authInfo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPlatformGroupName() {
		return platformGroupName;
	}
	public void setPlatformGroupName(String platformGroupName) {
		this.platformGroupName = platformGroupName;
	}
	public String getPlatformTypeClass() {
		return platformTypeClass;
	}
	public void setPlatformTypeClass(String platformTypeClass) {
		this.platformTypeClass = platformTypeClass;
	}
	
	
}
