package com.jcloud.cms.common.utils;

public class CheckUtil {

    /**
     * 防xss漏洞用
     * 
     * @param str
     * @return
     */
    public static String replaceInvaidStr(String str) {
        if (str != null) {
            str = filterString(str);
            String reg = "[|#$%@'\"<>\\\\+]";
            str = str.replaceAll(reg, "");
            return str;
        } else {
            return null;
        }
    }

    /**
     * 防xss漏洞用
     *
     * @param str
     * @return
     */
    public static String replaceColor(String str) {
        if (str != null) {
            str = filterString(str);
            String reg = "#[0-9a-zA-Z]{6}:";
            str = str.replaceAll(reg, "");
            return str;
        } else {
            return null;
        }
    }


    /**
     * 防xss漏洞用
     * 不替换邮箱
     * 
     * @param str
     * @return
     */
    public static String replaceForEmail(String str) {
        if (str != null) {
            str = filterString(str);
            String reg = "[|#$%'\"<>\\\\+]";
            str = str.replaceAll(reg, "");
            return str;
        } else {
            return null;
        }
    }

    public static String filterBankCodeStr(String str) {
        String regular = "(0123456789- )";
        if (str != null) {
            str = filterString(str);
            StringBuffer newStr = new StringBuffer();
            char[] array = str.toCharArray();
            for (int i = 0; i < array.length; i++) {
                if (regular.indexOf(array[i] + "") > -1) {
                    newStr.append(array[i] + "");
                }
            }
            return newStr.toString();
        }
        return null;
    }

    /**
     * 
     * 过滤替换掉mysql不支持存储的无效字符
     * 
     * @param charSequence
     * @return
     */
    public static String filterString(CharSequence charSequence) {
        StringBuffer sb = new StringBuffer("");
        if (charSequence != null && charSequence.length() > 0) {
            sb = new StringBuffer();
            for (int i = 0; i < charSequence.length(); i++) {
                char ch = charSequence.charAt(i);
                if (!Character.isHighSurrogate(ch) && !Character.isLowSurrogate(ch)) {
                    sb.append(ch);
                } else {
                    sb.append("??");
                }
            }
        }

        return sb.toString();
    }
    
    
    /**
     * 验证是否是0或正数
     * @param data
     * @return
     */
    public static boolean isNotNegativeNum(String data){
        return data != null && !"".equals(data) && data.matches("^\\d+\\.?\\d*$");
    }
    
    
    /**
     * 验证是否是正整数
     * @param data
     * @return
     */
    public static boolean isPositiveIntNum(String data){
        return data != null && !"".equals(data) && data.matches("^[1-9]+\\d*$");
    }
}
