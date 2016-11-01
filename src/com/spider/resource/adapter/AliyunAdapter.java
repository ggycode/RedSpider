package com.spider.resource.adapter;

import javax.faces.application.FacesMessage.Severity;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.api.AliyunClient;
import com.aliyun.api.DefaultAliyunClient;
import com.aliyuncs.IAcsClient;
import com.spider.resource.model.Platform;

@Service("aliyunAdapter")
public class AliyunAdapter implements ResourceAdapter {
	
	private AliyunClient client;
    
    private AliyunClient aliyunAccountClient;
    
    private AliyunClient aliyunOssAdminClient;

    private IAcsClient iAcsClient;
    
    private String accessKeyId;
	
	private String accessKeySecret;
	
	private String serverUrl;
	
	public static String ALIYUN_ACCOUNT_URL = "http://account.aliyuncs.com/";
	
	public static String ALIYUN_OSS_ADMIN_URL = "http://oss-admin.aliyuncs.com/";
	
	private Platform platform;
	
	@Override
	public void config(Platform platform) {
		this.platform = platform;
		String auth = platform.getAuthInfo();
		this.accessKeyId = JSONObject.parseObject(auth).getString("accessKeyId");
		this.accessKeySecret = JSONObject.parseObject(auth).getString("accessKeySecret");
		this.serverUrl = platform.getUrl();
		this.client = new DefaultAliyunClient(serverUrl,accessKeyId, accessKeySecret);
		this.aliyunAccountClient = new DefaultAliyunClient(ALIYUN_ACCOUNT_URL,accessKeyId, accessKeySecret);
		this.aliyunOssAdminClient = new DefaultAliyunClient(ALIYUN_OSS_ADMIN_URL,accessKeyId, accessKeySecret);
	}

	public AliyunClient getClient() {
		return client;
	}

	public void setClient(AliyunClient client) {
		this.client = client;
	}

	public AliyunClient getAliyunAccountClient() {
		return aliyunAccountClient;
	}

	public void setAliyunAccountClient(AliyunClient aliyunAccountClient) {
		this.aliyunAccountClient = aliyunAccountClient;
	}

	public AliyunClient getAliyunOssAdminClient() {
		return aliyunOssAdminClient;
	}

	public void setAliyunOssAdminClient(AliyunClient aliyunOssAdminClient) {
		this.aliyunOssAdminClient = aliyunOssAdminClient;
	}

	@Override
	public Platform getPlatform() {
		return platform;
	}
	
}
