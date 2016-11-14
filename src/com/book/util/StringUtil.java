package com.book.util;

/**
 * 字符串工具类
 * @author Administrator
 *
 */
public class StringUtil {

	/**
	 * 判断是否为空
	 * @param string
	 * @return
	 */
	public static boolean isEmpty(String string) {
		if (string==null || "".equals(string.trim())) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 判断是否不为空
	 * @param string
	 * @return
	 */
	public static boolean isNotEmpty(String string) {
		if (string!=null && !"".equals(string.trim())) {
			return true;
		}else {
			return false;
		}
	}
}
