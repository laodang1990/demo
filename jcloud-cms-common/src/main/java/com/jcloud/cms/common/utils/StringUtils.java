package com.jcloud.cms.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


/**
 * @author dyc
 * @date 2014年12月30日下午4:57:02 	
 * @version 1.0
 */
public class StringUtils {
	private final static Logger log = LoggerFactory.getLogger(StringUtils.class);
	
	public StringUtils() {
	}

	public static String replacePattern(String source, String regex, String replacement) {
		return Pattern.compile(regex, 32).matcher(source).replaceAll(replacement);
	}
	
	/**
	 * 六位随机码
	 * @author dyc
	 * @return
	 * @throws PatternSyntaxException
	 */
	public static String randCode(Integer num) throws PatternSyntaxException {
		String strReturn = randomCode(num);
		while(strReturn.length()!=num){
			strReturn = randomCode(num);
		}
		return strReturn;
	}
	
	/**
	 * 返回n个随机数
	 * @author liujinshan
	 * @param n
	 * @return
	 * @throws PatternSyntaxException
	 */
	public static String randomCode(int n) throws PatternSyntaxException {
		double code = Math.random();
		String codeStr = String.valueOf(code);
		return codeStr.substring(2, 2+n);
	}
	
	/**
	 * 验证输入的邮箱格式是否符合
	 * 
	 * @param email
	 * @return 是否合法
	 */
	public static boolean isEmail(String email) {
	    if(!StringUtils.isNullString(email)){
	        final String pattern1 = "^([a-z0-9A-Z]+[_-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	        final Pattern pattern = Pattern.compile(pattern1);
	        final Matcher matcher = pattern.matcher(email);
	        return matcher.matches(); 
	    }else{
	        return false;
	    }
		
	}
	
	/** 
	 * @param str
	 * String
	 * @return boolean
	 */
	public static boolean isNullString(String str) {
		boolean isNull = false;
		if (str == null || (str != null && str.trim().equals("")))
			isNull = true;
		return isNull;
	}

	/**
	 * @param mobile
	 * String
	 * @return boolean
	 */
	public static boolean isMobileNO(String mobile) {
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Matcher m = p.matcher(mobile);
		return m.matches();
	}

		/**
         * 返回一个时间名称
         *
         * @param c_path
         *            客户端的文件路径
         * @return
         */
	public static String getFileTimeName(String c_path) {
		SimpleDateFormat shijian = new SimpleDateFormat("yyyyMMDDhhmmssSSS");
		String systemTime = shijian.format(new java.util.Date());
		int temp = c_path.lastIndexOf(".");
		String subName = c_path.substring(temp + 1);
		String filename = systemTime + "." + subName;
		return filename;
	}
	
}
