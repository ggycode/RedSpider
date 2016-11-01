package com.spider.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encrypt {

	private MD5Encrypt() {
	}

	/**
	 * 将字符串加密
	 * @param s
	 * @return
	 */
	public static String encrypt(String s) {
		return encryptString(s);
	}

	/**
	 * 比较一个加密的和非加密的字符串
	 * @param encryptedString
	 * @param plainString
	 * @return
	 */
	public static boolean compareEncrypted(String encryptedString,
			String plainString) {
		return encryptedString != null
				&& encryptedString.equals(encryptString(plainString));
	}

	public static String byte2hex(byte abyte0[]) {
		String s = "";
		String s1 = "";
		for (int i = 0; i < abyte0.length; i++) {
			String s2 = Integer.toHexString(abyte0[i] & 0xff);
			if (s2.length() == 1)
				s = s + "0" + s2;
			else
				s = s + s2;
		}
		return s.toUpperCase();
	}

	public static byte[] hex2byte(String s) {
		byte abyte0[] = new byte[s.length() / 2];
		int i = 0;
		int j = 0;
		for (; i < s.length(); i += 2) {
			abyte0[j] = (byte) (Integer.parseInt(s.substring(i, i + 2), 16) & 0xff);
			j++;
		}

		return abyte0;
	}

	private static String encryptString(String s) {
		if (s == null || s.length() == 0)
			return null;
		byte abyte0[] = s.getBytes();
		MessageDigest messagedigest = null;
		try {
			messagedigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException nosuchalgorithmexception) {
			return null;
		}
		messagedigest.reset();
		messagedigest.update(abyte0);
		byte abyte1[] = messagedigest.digest();
		String s1 = byte2hex(abyte1);
		return s1;
	}
	
}
