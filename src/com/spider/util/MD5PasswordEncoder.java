package com.spider.util;

import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("md5PasswordEncode")
public class MD5PasswordEncoder implements PasswordEncoder {

	@Override
	public String encodePassword(String submitPass, Object salt) throws DataAccessException {
		return MD5Encrypt.encrypt(submitPass);
	}

	@Override
	public boolean isPasswordValid(String savePass, String submitPass, Object salt) throws DataAccessException {
		if (savePass == null || submitPass == null) {
			throw new RuntimeException("ÃÜÂë²»ÄÜÎª¿Õ£¡");
		}
		if (MD5Encrypt.compareEncrypted(savePass, submitPass)) {
			return true;
		}

		return false;
	}

}
