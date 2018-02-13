package org.game.server.common.util;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class BirthdayUtil {

	public static String getBirthdyByCardId(String cardId) {
		String month = "";
		String day = "";
		System.out.println(cardId.length());
		if (cardId.length() == 18) {
			month = cardId.substring(10, 12);
			day = cardId.substring(12, 14);
		} else if (cardId.length() == 15) {
			month = cardId.substring(8, 10);
			day = cardId.substring(10, 12);
		}
		if (StringUtils.isNotEmpty(month) && StringUtils.isNotEmpty(day)) {
			return month + "-" + day;
		}
		return "";
	}
	
	/**
	 * 根据出生日期计算年龄
	 * @param birthday format yyyy-MM-dd
	 * @return
	 */
	public static int getAge(String birthday) {
		return getAge(DateUtil.YEAR_MONTH_DAY.format(birthday));
	}
	
	public static int getAge(Date birthday) {
        int age = 0;
        Calendar born = Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        if (birthday != null) {
            now.setTime(new Date());
            born.setTime(birthday);
            if (born.after(now)) {
                throw new IllegalArgumentException("年龄不能超过当前日期");
            }
            age = now.get(Calendar.YEAR) - born.get(Calendar.YEAR);
            int nowDayOfYear = now.get(Calendar.DAY_OF_YEAR);
            int bornDayOfYear = born.get(Calendar.DAY_OF_YEAR);
            if (nowDayOfYear < bornDayOfYear) {
                age -= 1;
            }
        }
        return age;
    }
}
