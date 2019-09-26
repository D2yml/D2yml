package DyUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.sound.sampled.ReverbType;

import DyStructure.DyStack;
import DyStructure.Stack.DyLinkedStack;

public class StringUtil {
	public static void main(String[] args) {
		reversal("");
	}

	/**
	 * 使用链表栈进行字符串翻转
	 * 
	 * @param str
	 */
	public static String reversal(String str) {
		if (isEmpty(str)) {
			throw new NullPointerException("传入字符串为空");
		}
		DyStack<String> stack = new DyLinkedStack<String>();
		StringBuffer buff = new StringBuffer();
		for (char c : str.toCharArray()) {
			stack.push(String.valueOf(c));
		}
		for (int i = 0; i < stack.size();) {
			buff.append(stack.pop());
		}
		return buff.toString();
	}

	/**
	 * 判断字符串中是否含有中文
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isChinese(String str) {
		if (isEmpty(str))
			return false;
		for (char c : str.toCharArray()) {
			if (isChinese(c))
				return true;// 有一个中文字符就返回
		}
		return false;
	}

	private static boolean isChinese(char c) {
		return c >= 0x4E00 && c <= 0x9FA5;// 根据字节码判断
	}

	/**
	 * 生成32位唯一id
	 * 
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * 字符串判空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
//		str = str.toString();
		if (str == null || str == "")
			return true;
		return false;
	}

	/**
	 * map判空
	 * @param map
	 * @return
	 */
	public static boolean mapIsEmpty(Map map) {
		if (map == null || map.size() == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 检查手机号码;验证前三位
	 * Date : 2018年12月28日 09:07:04
	 * @author D2yml
	 * @param phone
	 * @return
	 */
	public static boolean checkPhone(String phone) {
		phone = phone.trim();
		try {
			if (phone == null) {
				return false;
			}
		} catch (NullPointerException e) {
			return false;
		}
		if (phone.matches("^(13\\d|14[579]|15[^4\\D]|17[^49\\D]|18[^019\\D]|199)\\d{8}$")) {
			return true;
		}
		return false;
	}

	/**
	 * 格式化date
	 * @param formate
	 * @param date
	 * @return
	 */
	public static String customFormateDate(String formate, Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(formate);
		try {
			if (date != null)
				return sdf.format(date);
			else
				return sdf.format(new Date());
		} catch (Exception e) {
			e.printStackTrace();
			return sdf.format(new Date());
		}
	}
}
