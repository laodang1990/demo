package com.jcloud.cms.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * java去除html标签
 *                       
 * @Filename: HTMLSpiritUtils.java
 * @Description: 
 * @Version: 1.0
 * @Author: yangzhao
 * @Email: 2212691977@qq.com
 * @History:<br>
 *
 */
public class HTMLSpiritUtils {
	
	public static final String REGEX_STR_OF_HTML_TAG = "</?[a-zA-Z]+[^>]*>";
	
	public static String delHTMLTag(String htmlStr){ 
        String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式 
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式 
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式 
         
        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE); 
        Matcher m_script=p_script.matcher(htmlStr); 
        htmlStr=m_script.replaceAll(""); //过滤script标签 
         
        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
        Matcher m_style=p_style.matcher(htmlStr); 
        htmlStr=m_style.replaceAll(""); //过滤style标签 
         
        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
        Matcher m_html=p_html.matcher(htmlStr); 
        htmlStr=m_html.replaceAll(""); //过滤html标签 

        return htmlStr.trim(); //返回文本字符串 
    } 
	
	public static String removeHtmlTag(String sourceContent){
		sourceContent = specialSymbolsToHtmlTag(sourceContent);
		return StringUtils.replacePattern(sourceContent, REGEX_STR_OF_HTML_TAG, "");
	}
	
	public static String htmlTagToSpecialSymbols(String content) {
		if (content == null)
			return "";
		String html = content;
		html = html.replaceAll("&", "&amp;");
		html = html.replaceAll("\"", "&quot;");
		html = html.replaceAll("\t", "&nbsp;&nbsp;");
		html = html.replaceAll(" ", "&nbsp;");
		html = html.replaceAll("<", "&lt;");
		html = html.replaceAll(">", "&gt;");
		return html;
	}
	
	public static String specialSymbolsToHtmlTag(String content) {
		if (content == null)
			return "";
		String html = content;
		html = html.replaceAll("&amp;", "&");
		html = html.replaceAll("&quot;", "\"");
		html = html.replaceAll("&nbsp;&nbsp;", "\t");
		html = html.replaceAll("&nbsp;", " ");
		html = html.replaceAll("&lt;", "<");
		html = html.replaceAll("&gt;", ">");
		return html;
	}
}
