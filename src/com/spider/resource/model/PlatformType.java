package com.spider.resource.model;

public class PlatformType {
	private String id;
    private String adapterClass;
    private String platform;
    private String version;
    private String scopeModel;
    private String authInfoModel;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAdapterClass() {
		return adapterClass;
	}
	public void setAdapterClass(String adapterClass) {
		this.adapterClass = adapterClass;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getScopeModel() {
		return scopeModel;
	}
	public void setScopeModel(String scopeModel) {
		this.scopeModel = scopeModel;
	}
	public String getAuthInfoModel() {
		return authInfoModel;
	}
	public void setAuthInfoModel(String authInfoModel) {
		this.authInfoModel = authInfoModel;
	}
    
    
}
