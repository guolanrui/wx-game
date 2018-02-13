package org.game.server.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.GenericValidator;

/**
 * 验证类公共方法
 * */
public class ValidatorUtil {
	/**
	 * 验证参数是否是int类型
	 * 
	 * @author LiuJun
	 * */
	public static <T> boolean isInt(T value) {
		return GenericValidator.isInt(value.toString());
	}

	/**
	 * 验证参数是否是Float类型
	 * 
	 * @author LiuJun
	 * */
	public static <T> boolean isFloat(T value) {
		return GenericValidator.isFloat(value.toString());
	}

	/**
	 * 验证参数是否是float类型
	 * 
	 * @author LiuJun
	 * */
	public static <T> boolean isDouble(T value) {
		return GenericValidator.isDouble(value.toString());
	}


	/**
	 * 验证参数是否是date类型
	 * 
	 * @author LiuJun
	 * */
	public static <T> boolean isInRange(T value, int max, int min) {
		if (isInt(value)) {
			return GenericValidator.isInRange((Integer) value, min, max);
		}
		return false;
	}

	/**
	 * 验证参数是否是date类型
	 * 
	 * @author LiuJun
	 * */
	public static <T> boolean isInRange(T value, float max, float min) {
		if (isFloat(value)) {
			return GenericValidator.isInRange((Float) value, min, max);
		}
		return false;
	}

	/**
	 * 验证参数是否是date类型
	 * 
	 * @author LiuJun
	 * */
	public static <T> boolean isInRange(T value, double max, double min) {
		if (isDouble(value)) {
			return GenericValidator.isInRange((Double) value, min, max);
		}
		return false;
	}

	/**
	 * 验证邮箱地址是否合法
	 * 
	 * @author LiuJun
	 * */
	public static boolean isEmail(String value) {
		return GenericValidator.isEmail(value);
	}

	

	/**
	 * 正则表达式验证
	 * 
	 * @author LiuJun
	 * */
	public static boolean matchRegexp(String value, String regexp) {
		return GenericValidator.matchRegexp(value, regexp);
	}

	/**
	 * 验证座机号码
	 * 
	 * @author LiuJun
	 * */
	public static boolean isPhoneNumber(String value) {
		String regexp = "^(0[0-9]{2,3}\\-)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?$";
		if (matchRegexp(value, regexp)) {
			return true;
		}
		return false;
	}

	/**
	 * 验证手机号码
	 * 
	 * @author LiuJun
	 * */
	public static boolean isPhoneNo(String value) {
		if(StringUtils.isBlank(value)) return false;
		String regexp = "^[1][3458]\\d{9}$";
		if (matchRegexp(value, regexp)) {
			return true;
		}
		return false;
	}

	/**
	 * 验证座机号码和手机号码
	 * 
	 * @author LiuJun
	 * */
	public static boolean isTelephoneNumber(String value) {
		if (isPhoneNumber(value) || isPhoneNo(value)) {
			return true;
		}
		return false;
	}

	/**
	 * 是否有emoji表情
	 * @param source
	 * @return
	 */
	public static boolean isEmoji(String source) { 
	    Pattern emoji = Pattern.compile ("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",Pattern.UNICODE_CASE | Pattern . CASE_INSENSITIVE ) ;
	    Matcher emojiMatcher = emoji.matcher(source);
	    return emojiMatcher.find();
	}

}
