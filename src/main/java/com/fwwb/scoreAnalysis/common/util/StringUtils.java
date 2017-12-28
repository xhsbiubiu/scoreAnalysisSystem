/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.fwwb.scoreAnalysis.common.util;


/**
 * 字符串工具类, 继承org.apache.commons.lang3.StringUtils类
 * @author wzy
 * @version 2017-05-31
 */
public class StringUtils {

	public static boolean isEmpty(final Object obj) {
		if (obj != null && !obj.toString().trim().equals("")) {
			return false;
		}
		return true;
	}

	public static boolean isNotEmpty(final Object obj) {
		if (obj != null && !obj.toString().trim().equals("")) {
			return true;
		}
		return false;
	}

	public static final int strToInt(String s, int i) {

		if (s == null)
			return i;
		if (!strIsDigital(s) || s.length() < 1)
			return i;
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return 0;
		}
	}

	public static final boolean strIsDigital(String s) {
		boolean flag = false;
		boolean flag1 = true;
		if (s == null) {
			return false;
		}
		char ac[] = s.toCharArray();
		for (int i = 0; i < ac.length;) {
			if (!Character.isDigit(ac[i]))
				flag1 = false;
			break;
		}

		return flag1;
	}

	/** Object转int,如不存在,全部为0 **/
	public static int toInt(Object obj) {
		int num = 0;
		if (obj != null && !obj.toString().equals("")) {
			try {
				Integer nums = Integer.valueOf(obj.toString());
				if (nums != null && nums > 0) {
					num = nums;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return num;
	}

	/**
	 * 存放Hex[16进制]的字符集合
	 */
	private static final char[] _BytesChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	/**
	 * 将指定的Hex字符串转换成byte[]输出
	 *
	 * @param value
	 *            要处理的Hex字符串
	 * @return byte[]数组
	 */
	public static final byte[] hexString2bytes(String value) {
		if (value == null) {
			return null;
		}
		int len = value.length();
		if (len % 2 != 0) {
			return null;
		}
		len = len / 2;
		byte[] temp = new byte[len];
		value = value.toUpperCase();
		for (int n = 0; n < len; n++) {
			int b = 0;
			char c = value.charAt(n * 2);
			if (c >= '0' && c <= '9') {
				b += ((c - '0') << 4 & 0xF0);
			} else if (c >= 'A' && c <= 'F') {
				b += ((c - 'A' + 10) << 4 & 0xF0);
			} else {
				return null;
			}
			c = value.charAt(n * 2 + 1);
			if (c >= '0' && c <= '9') {
				b += (c - '0');
			} else if (c >= 'A' && c <= 'F') {
				b += (c - 'A') + 10;
			} else {
				return null;
			}
			temp[n] = (byte) (b & 0xFF);
		}
		return temp;
	}

	/**
	 * 将指定的byte[]数组转成16进制的字符串输出
	 *
	 * @param value
	 *            要处理的byte[]数组
	 * @return 如果byte[]为空,则返回 Null,否则返回处理后的字符串
	 */
	public static final String bytes2HexString(byte[] value) {
		if (value == null) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		for (byte b : value) {
			sb.append(_BytesChars[(b >> 4) & 0xF]);
			sb.append(_BytesChars[b & 0xF]);
		}
		return sb.toString();
	}


}
