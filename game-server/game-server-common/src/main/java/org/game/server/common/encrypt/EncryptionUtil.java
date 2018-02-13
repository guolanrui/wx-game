package org.game.server.common.encrypt;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 密码加密工具类
 * @author lwpo
 *
 */
public class EncryptionUtil {
	
	/**
	 * md5
	 * @param value
	 * @return
	 */
	public static String md5Hex(String value) {
		return DigestUtils.md5Hex(value);
	}

	/**
	 * sha1加密
	 * 
	 * @param value
	 *            要加密的值
	 * @return sha1加密后的值
	 */
	public static String sha1Hex(String value) {
		return DigestUtils.sha1Hex(value);
	}

	/**
	 * sha256加密
	 * 
	 * @param value
	 *            要加密的值
	 * @return sha256加密后的值
	 */
	public static String sha256Hex(String value) {
		return DigestUtils.sha256Hex(value);
	}

}
