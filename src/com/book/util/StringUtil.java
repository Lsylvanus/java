package com.book.util;

/**
 * �ַ���������
 * @author Administrator
 *
 */
public class StringUtil {

	/**
	 * �ж��Ƿ�Ϊ��
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
	 * �ж��Ƿ�Ϊ��
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
