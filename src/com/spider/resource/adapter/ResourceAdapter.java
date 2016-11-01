package com.spider.resource.adapter;

import com.spider.resource.model.Platform;

public interface ResourceAdapter {
	public void config(Platform platform);
	
	public Platform getPlatform();
}
