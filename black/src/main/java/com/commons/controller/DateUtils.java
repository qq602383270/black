package com.commons.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期处理工具函数包,包括日期对象、日期字符串相关转换函数
 * 
 * @version 1.0 <br>
 */
public class DateUtils {
	/**
	 * 定义常见的时间格式
	 * 
	 */
	private static String[] dateFormat = { "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss", "yyyy年MM月dd日HH时mm分ss秒",
			"yyyy-MM-dd", "yyyy/MM/dd", "yy-MM-dd", "yy/MM/dd", "yyyy年MM月dd日", "HH:mm:ss", "yyyyMMddHHmmss", "yyyyMMdd",
			"yyyy.MM.dd", "yy.MM.dd", "MM月dd日HH时mm分", "yyyy年MM月dd日 HH:mm:ss", "yyyy-MM-dd HH:mm" };

	/**
	 * <p>
	 * <b>作者：</b>Administrator
	 * </p>
	 * <p>
	 * <b>日期：</b>2011-9-8
	 * </p>
	 * <p>
	 * <b>方法描述：</b> 将日期格式从 java.util.Calendar 转到 java.sql.Timestamp 格式
	 * </p>
	 * 
	 * @param date
	 *            格式表示的日期
	 * @return
	 * 		<p>
	 *         <b>使用说明：</b>
	 * 
	 *         </p>
	 */
	public static Timestamp convUtilCalendarToSqlTimestamp(Calendar date) {
		if (date == null)
			return null;
		else
			return new Timestamp(date.getTimeInMillis());
	}

	/**
	 * <p>
	 * <b>作者：</b>Administrator
	 * </p>
	 * <p>
	 * <b>日期：</b>2011-9-8
	 * </p>
	 * <p>
	 * <b>方法描述：</b> 将日期格式从 java.util.Timestamp 转到 java.util.Calendar 格式
	 * </p>
	 * 
	 * @param date
	 *            格式表示的日期
	 * @return
	 * 		<p>
	 *         <b>使用说明：</b>
	 * 
	 *         </p>
	 */
	public static Calendar convSqlTimestampToUtilCalendar(Timestamp date) {
		if (date == null)
			return null;
		else {
			java.util.GregorianCalendar gc = new java.util.GregorianCalendar();
			gc.setTimeInMillis(date.getTime());
			return gc;
		}
	}

	/**
	 * <p>
	 * <b>作者：</b>Administrator
	 * </p>
	 * <p>
	 * <b>日期：</b>2011-9-8
	 * </p>
	 * <p>
	 * <b>方法描述：</b> 解析一个字符串，形成一个Calendar对象，适应各种不同的日期表示法
	 * </p>
	 * 
	 * @param dateStr
	 *            期望解析的字符串，注意，不能传null进去，否则出错
	 * @return
	 * 		<p>
	 *         <b>使用说明：</b> <br>
	 *         <br>
	 *         可输入的日期字串格式如下：
	 * 
	 *         <br>
	 *         "yyyy-MM-dd HH:mm:ss", <br>
	 *         "yyyy/MM/dd HH:mm:ss", <br>
	 *         "yyyy年MM月dd日HH时mm分ss秒", <br>
	 *         "yyyy-MM-dd", <br>
	 *         "yyyy/MM/dd", <br>
	 *         "yy-MM-dd", <br>
	 *         "yy/MM/dd", <br>
	 *         "yyyy年MM月dd日", <br>
	 *         "HH:mm:ss", <br>
	 *         "yyyyMMddHHmmss", <br>
	 *         "yyyyMMdd", <br>
	 *         "yyyy.MM.dd", <br>
	 *         "yy.MM.dd"
	 *         </p>
	 */
	public static Calendar parseDate(String dateStr) {
		if (dateStr == null || dateStr.trim().length() == 0)
			return null;

		Date result = parseDate(dateStr, 0);

		Calendar cal = Calendar.getInstance();
		cal.setTime(result);

		return cal;
	}

	/**
	 * <p>
	 * <b>作者：</b>Administrator
	 * </p>
	 * <p>
	 * <b>日期：</b>2011-9-8
	 * </p>
	 * <p>
	 * <b>方法描述：</b> 将一个日期转成日期时间格式，格式这样 2002-08-05 21:25:21
	 * </p>
	 * 
	 * @param date
	 *            期望格式化的日期对象
	 * @return 返回格式化后的字符串
	 *         <p>
	 *         <b>使用说明：</b> <br>
	 *         Calendar date = new GregorianCalendar(); <br>
	 *         String ret = DateUtils.toDateTimeStr(date); <br>
	 *         返回：
	 * 
	 *         <br>
	 *         ret = "2002-12-04 09:13:16";
	 *         </p>
	 */
	public static String toDateTimeStr(Calendar date) {
		if (date == null)
			return null;
		return new SimpleDateFormat(dateFormat[0]).format(date.getTime());
	}

	/**
	 * <p>
	 * <b>作者：</b>Administrator
	 * </p>
	 * <p>
	 * <b>日期：</b>2011-9-8
	 * </p>
	 * <p>
	 * <b>方法描述：</b> 将一个日期转成日期时间格式
	 * </p>
	 * 
	 * @param format
	 *            日志格式序号
	 * @param date
	 *            期望格式化的日期对象
	 * @return
	 * 		<p>
	 *         <b>使用说明：</b>
	 * 
	 *         </p>
	 */
	public static String toDateTimeStr(int format, Calendar date) {
		if (date == null)
			return null;

		return new SimpleDateFormat(dateFormat[format]).format(date.getTime());
	}

	/**
	 * <p>
	 * <b>作者：</b>Administrator
	 * </p>
	 * <p>
	 * <b>日期：</b>2011-9-8
	 * </p>
	 * <p>
	 * <b>方法描述：</b> 将一个日期转成日期格式， 格式：yyyy-MM-dd
	 * </p>
	 * 
	 * @param date
	 *            期望格式化的日期对象
	 * @return 返回格式化后的字符串
	 *         <p>
	 *         <b>使用说明：</b>
	 * 
	 *         </p>
	 */
	public static String toDateStr(Calendar date) {
		if (date == null)
			return null;
		return new SimpleDateFormat(dateFormat[3]).format(date.getTime());
	}

	/**
	 * <p>
	 * <b>作者：</b>Administrator
	 * </p>
	 * <p>
	 * <b>日期：</b>2011-9-8
	 * </p>
	 * <p>
	 * <b>方法描述：</b> 根据format数组的序号，将Calendar转换为对应格式的String
	 * </p>
	 * 
	 * @param date
	 *            要转换的日期对象
	 * @param formatIndex
	 *            format数组中的索引
	 * @return 返回格式化后的字符串
	 *         <p>
	 *         <b>使用说明：</b>
	 * 
	 *         </p>
	 */
	public static String toDateStrByFormatIndex(Calendar date, int formatIndex) {
		if (date == null)
			return null;
		return new SimpleDateFormat(dateFormat[formatIndex]).format(date.getTime());
	}

	/**
	 * <p>
	 * <b>作者：</b>Administrator
	 * </p>
	 * <p>
	 * <b>日期：</b>2011-9-8
	 * </p>
	 * <p>
	 * <b>方法描述：</b> 第一个日期与第二个日期相差的天数
	 * </p>
	 * 
	 * @param d1
	 *            第一个日期
	 * @param d2
	 *            第二个日期
	 * @return 两个日期之间相差的天数
	 *         <p>
	 *         <b>使用说明：</b>
	 * 
	 *         </p>
	 */
	public static int calendarMinus(Calendar d1, Calendar d2) {
		if (d1 == null || d2 == null) {
			return 0;
		}

		d1.set(Calendar.HOUR_OF_DAY, 0);
		d1.set(Calendar.MINUTE, 0);
		d1.set(Calendar.SECOND, 0);

		d2.set(Calendar.HOUR_OF_DAY, 0);
		d2.set(Calendar.MINUTE, 0);
		d2.set(Calendar.SECOND, 0);

		long t1 = d1.getTimeInMillis();
		long t2 = d2.getTimeInMillis();
		long daylong = 3600 * 24 * 1000;
		t1 = t1 - t1 % (daylong);
		t2 = t2 - t2 % (daylong);

		long t = t1 - t2;
		int value = (int) (t / (daylong));
		return value;
	}

	/**
	 * <p>
	 * <b>作者：</b>Administrator
	 * </p>
	 * <p>
	 * <b>日期：</b>2011-9-8
	 * </p>
	 * <p>
	 * <b>方法描述：</b> 第一个日期与第二个日期相差的天数
	 * </p>
	 * 
	 * @param d1
	 *            第一个日期
	 * @param d2
	 *            第二个日期
	 * @return 两个日期之间相差的天数
	 *         <p>
	 *         <b>使用说明：</b>
	 * 
	 *         </p>
	 */
	public static long calendarminus(Calendar d1, Calendar d2) {
		if (d1 == null || d2 == null) {
			return 0;
		}
		return (d1.getTimeInMillis() - d2.getTimeInMillis()) / (3600 * 24000);
	}

	/**
	 * <p>
	 * <b>作者：</b>Administrator
	 * </p>
	 * <p>
	 * <b>日期：</b>2011-9-8 10:00:00
	 * </p>
	 * <p>
	 * <b>方法描述：</b> 第一个日期与第二个日期相差的秒数
	 * </p>
	 * 
	 * @param d1
	 *            第一个日期
	 * @param d2
	 *            第二个日期
	 * @return 两个日期之间相差的秒数
	 *         <p>
	 *         <b>使用说明：</b>
	 * 
	 *         </p>
	 */
	public static long calendarTime(Calendar d1, Calendar d2) {
		if (d1 == null || d2 == null) {
			return 0;
		}
		return (d1.getTimeInMillis() - d2.getTimeInMillis()) / 1000;
	}

	/**
	 * <p>
	 * <b>作者：</b>Administrator
	 * </p>
	 * <p>
	 * <b>日期：</b>2015-12-9 17:00:00
	 * </p>
	 * <p>
	 * <b>方法描述：</b> 第一个日期与第二个日期相差的天数
	 * </p>
	 * 
	 * @param early
	 *            第一个日期
	 * @param late
	 *            第二个日期
	 * @return 两个日期之间相差的天数
	 *         <p>
	 *         <b>使用说明：</b>
	 * 
	 *         </p>
	 */
	public static final int daysBetween(Date early, Date late) {
		java.util.Calendar calst = java.util.Calendar.getInstance();
		java.util.Calendar caled = java.util.Calendar.getInstance();
		calst.setTime(early);
		caled.setTime(late);
		// 设置时间为0时
		calst.set(java.util.Calendar.HOUR_OF_DAY, 0);
		calst.set(java.util.Calendar.MINUTE, 0);
		calst.set(java.util.Calendar.SECOND, 0);
		caled.set(java.util.Calendar.HOUR_OF_DAY, 0);
		caled.set(java.util.Calendar.MINUTE, 0);
		caled.set(java.util.Calendar.SECOND, 0);
		// 得到两个日期相差的天数
		int days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst.getTime().getTime() / 1000)) / 3600 / 24;
		return days;
	}

	/**
	 * <p>
	 * <b>作者：</b>Administrator
	 * </p>
	 * <p>
	 * <b>日期：</b>2011-9-9
	 * </p>
	 * <p>
	 * <b>方法描述：</b> 内部方法，根据某个索引中的日期格式解析日期
	 * </p>
	 * 
	 * @param dateStr
	 *            日期的字符串形式
	 * @param index
	 *            日期格式索引
	 * @return 符合日期字符串的日期对象
	 *         <p>
	 *         <b>使用说明：</b>
	 * 
	 *         </p>
	 */
	public static Date parseDate(String dateStr, int index) {
		DateFormat df = null;
		try {
			df = new SimpleDateFormat(dateFormat[index]);
			return df.parse(dateStr);
		} catch (Exception aioe) {
			return null;
		}
	}

	/**
	 * <p>
	 * <b>作者：</b>Administrator
	 * </p>
	 * <p>
	 * <b>日期：</b>2011-9-9
	 * </p>
	 * <p>
	 * <b>方法描述：</b> 字符转日期,字符串格式："yyyy-MM-dd"，例如2006-01-01
	 * </p>
	 * 
	 * @param dateStr
	 *            日期的字符串形式
	 * @return 符合日期字符串的日期对象
	 *         <p>
	 *         <b>使用说明：</b>
	 * 
	 *         </p>
	 */
	public static Date StringToDate(String dateStr) {
		if (dateStr == null || dateStr.trim().length() == 0) {
			return null;
		}
		return parseDate(dateStr, 3);
	}

	/**
	 * 
	 * @Title: StringToDateTime
	 * @Description: 字符转日期,字符串格式："yyyy-MM-dd hh:mm:ss"，例如2006-01-01 11:11:11
	 * @param @param
	 *            dateStr
	 * @param @return
	 *            设定文件
	 * @return Date 返回类型
	 */
	public static Date StringToDateTime(String dateStr) {
		if (dateStr == null || dateStr.trim().length() == 0) {
			return null;
		}
		return parseDate(dateStr, 0);
	}

	/**
	 * <p>
	 * <b>作者：</b>Administrator
	 * </p>
	 * <p>
	 * <b>日期：</b>2011-9-9
	 * </p>
	 * <p>
	 * <b>方法描述：</b> 将日期转换为格式化后的日期字符串
	 * </p>
	 * 
	 * @param date
	 *            日期
	 * @param index
	 *            日期格式索引
	 * @return
	 * 		<p>
	 *         <b>使用说明：</b> <b>0:"yyyy-MM-dd HH:mm:ss"</br>
	 *         <b>1:"yyyy/MM/dd HH:mm:ss"</br>
	 *         <b>2:"yyyy年MM月dd日HH时mm分ss秒"</br>
	 *         <b>3:"yyyy-MM-dd"</br>
	 *         <b>4:"yyyy/MM/dd"</br>
	 *         <b>5:"yy-MM-dd"</br>
	 *         <b>6:"yy/MM/dd"</br>
	 *         <b>7:"yyyy年MM月dd日"</br>
	 *         <b>8:"HH:mm:ss"</br>
	 *         <b>9:"yyyyMMddHHmmss"</br>
	 *         <b>10:"yyyyMMdd"</br>
	 *         <b>11:"yyyy.MM.dd"</br>
	 *         <b>12:"yy.MM.dd", <b>13:"MM月dd日HH时mm分"</br>
	 *         <b>14:"yyyy年MM月dd日 HH:mm:ss"</br>
	 *         <b>15:"yyyy-MM-dd HH:mm"
	 *         </p>
	 */
	public static String dateToString(Date date, int index) {
		if (date == null) {
			return null;
		}
		return new SimpleDateFormat(dateFormat[index]).format(date);
	}

	/**
	 * <p>
	 * <b>作者：</b>Administrator
	 * </p>
	 * <p>
	 * <b>日期：</b>2011-9-9
	 * </p>
	 * <p>
	 * <b>方法描述：</b> 返回固定格式的日期字符串。转换结果格式为："yyyy-MM-dd"
	 * </p>
	 * 
	 * @param date
	 *            待转换的日期对象
	 * @return
	 * 		<p>
	 *         <b>使用说明：</b>
	 * 
	 *         </p>
	 */
	public static String dateToString(Date date) {
		if (date == null) {
			return null;
		}
		return new SimpleDateFormat(dateFormat[3]).format(date);
	}

	/**
	 * @Title: getDate
	 * @Description: 获取当前日期，"yyyy-MM-dd"
	 * @return String 返回类型
	 * @return
	 */
	public static String getDate() {

		return new SimpleDateFormat(dateFormat[3]).format(new Date());
	}

	/**
	 * @Title: getDateTime
	 * @Description: 获取当前日期，"yyyy-MM-dd HH:mm:ss"
	 * @param @return
	 *            设定文件
	 * @return String 返回类型
	 * @return
	 */
	public static String getDateTime() {

		return new SimpleDateFormat(dateFormat[0]).format(new Date());
	}

	/**
	 * <p>
	 * <b>作者：</b>Administrator
	 * </p>
	 * <p>
	 * <b>日期：</b>2011-9-9
	 * </p>
	 * <p>
	 * <b>方法描述：</b> 将日期格式从 java.util.Date 转到 java.sql.Timestamp 格式
	 * </p>
	 * 
	 * @param date
	 * @return
	 * 		<p>
	 *         <b>使用说明：</b>
	 * 
	 *         </p>
	 */
	public static Timestamp convUtilDateToSqlTimestamp(Date date) {
		if (date == null)
			return null;
		else
			return new Timestamp(date.getTime());
	}

	/**
	 * <p>
	 * <b>作者：</b>Administrator
	 * </p>
	 * <p>
	 * <b>日期：</b>2011-9-9
	 * </p>
	 * <p>
	 * <b>方法描述：</b> 将Date对象转换成Calendar对象
	 * </p>
	 * 
	 * @param date
	 * @return
	 * 		<p>
	 *         <b>使用说明：</b>
	 * 
	 *         </p>
	 */
	public static Calendar convUtilDateToUtilCalendar(Date date) {
		if (date == null)
			return null;
		else {
			java.util.GregorianCalendar gc = new java.util.GregorianCalendar();
			gc.setTimeInMillis(date.getTime());
			return gc;
		}
	}

	/**
	 * <p>
	 * <b>作者：</b>Administrator
	 * </p>
	 * <p>
	 * <b>日期：</b>2011-9-9
	 * </p>
	 * <p>
	 * <b>方法描述：</b> 根据某个索引中的日期格式解析日期
	 * </p>
	 * 
	 * @param dateStr
	 *            日期
	 * @param index
	 *            日期格式的索引
	 * @return
	 * 		<p>
	 *         <b>使用说明：</b>
	 * 
	 *         </p>
	 */
	public static Timestamp parseTimestamp(String dateStr, int index) {
		DateFormat df = null;
		try {
			df = new SimpleDateFormat(dateFormat[index]);
			return new Timestamp(df.parse(dateStr).getTime());
		} catch (ParseException pe) {
			return new Timestamp(parseDate(dateStr, index + 1).getTime());
		} catch (ArrayIndexOutOfBoundsException aioe) {
			return null;
		}
	}

	/**
	 * <p>
	 * <b>作者：</b>Administrator
	 * </p>
	 * <p>
	 * <b>日期：</b>2011-9-9
	 * </p>
	 * <p>
	 * <b>方法描述：</b> 返回固定格式的日期字符串。转换结果格式为："yyyy-MM-dd"
	 * </p>
	 * 
	 * @param date
	 *            待转换的日期对象
	 * @return
	 * 		<p>
	 *         <b>使用说明：</b>
	 * 
	 *         </p>
	 */
	public static Timestamp parseTimestamp(String dateStr) {
		DateFormat df = null;
		try {
			df = new SimpleDateFormat(dateFormat[3]);
			return new Timestamp(df.parse(dateStr).getTime());
		} catch (ParseException pe) {
			return null;
		} catch (ArrayIndexOutOfBoundsException aioe) {
			return null;
		}
	}

	/**
	 * @Title: calculateCalendarByday
	 * @Description: 日期加减天数
	 * @param calendar
	 *            需要操作的日期
	 * @param days
	 *            需要加减的天数
	 * @return Calendar 返回类型
	 */
	public static Calendar calculateCalendarByday(Calendar calendar, int days) {
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return calendar;
	}

	/**
	 * 日期加减天数
	 * 
	 * @param d
	 * @return
	 */
	public static Date calculateCalendarByday(Date d, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c = DateUtils.calculateCalendarByday(c, days);
		return c.getTime();
	}

	public static void main(String[] args) {
		Calendar c1 = DateUtils.convUtilDateToUtilCalendar(DateUtils.parseDate("2014-05-10 10:52", 15));
		// TimeZone tz = TimeZone.getTimeZone("GMT+08:00"); // 获得时区
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.SECOND, 0);
		// cal.setTimeZone(tz); // 设置时区
		// c1.setTimeZone(tz);
		System.out.println(c1.getTimeInMillis());
		System.out.println(cal.getTimeInMillis());
		System.out.println(c1.getTime());
		System.out.println(cal.getTime());
		System.out.println(DateUtils.calendarTime(c1, cal));
		;

		System.out.println("#####" + comparisonDateTime(getDateTime(), "2014-10-11 11:11:11"));
	}

	/**
	 * 
	 * @Title: ComparisonDateTime
	 * @Description: 比较时间，传入格式: yyyy-MM-dd HH:mm:ss
	 * @param @param
	 *            dateStr1
	 * @param @param
	 *            dateStr2
	 * @param @return
	 *            设定文件
	 * @return boolean 返回类型
	 */
	public static boolean comparisonDateTime(String dateStr1, String dateStr2) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(StringToDateTime(dateStr1));
		Calendar c2 = Calendar.getInstance();
		c2.setTime(StringToDateTime(dateStr1));
		return !c1.before(c2);
	}
}
