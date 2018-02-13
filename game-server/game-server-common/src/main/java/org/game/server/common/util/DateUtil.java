package org.game.server.common.util;

import org.apache.commons.lang3.time.FastDateFormat;

/**
 * 时间日期工具类
 * @author admin
 *
 */
public class DateUtil {
	
	public static final FastDateFormat YEAR_MONTH_DAY = FastDateFormat.getInstance("yyyy-MM-dd");
	
	public static final FastDateFormat WEEK = FastDateFormat.getInstance("EEE");
	
	public static final FastDateFormat YEAR_MONTH_DAY_HOUR_MINUTE_SECOND = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
	
	public static FastDateFormat getFastDateFormat(String pattern) {
		return FastDateFormat.getInstance(pattern);
	}
	
}
