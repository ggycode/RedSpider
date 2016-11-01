package com.spider.util;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

public class UUIDUtils {
	public static String getUuid() {
		UUID uuid = UUID.randomUUID();
		return StringUtils.replace(uuid.toString().trim(), "-", "");
	}
}
