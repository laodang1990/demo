package com.jcloud.cms.common.utils;

import org.apache.commons.lang.Validate;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DomainUtil {
    public DomainUtil() {
    }

    public static String getIPByDomain(String domain) throws UnknownHostException {
        Validate.notNull(domain);
        if(domain.contains(":")) {
            domain = domain.split(":")[0];
        }

        InetAddress address = InetAddress.getByName(domain);
        Validate.notNull(address);
        return address.getHostAddress();
    }

    public static boolean isInner(String ip) {
        return ip.startsWith("10.") || ip.startsWith("172.") || ip.startsWith("192.");
    }

    public static String getHost(String fullUrl) {
        if(fullUrl.contains("//")) {
            fullUrl = fullUrl.substring(fullUrl.indexOf("//") + 2);
        }

        int i = fullUrl.indexOf("/");
        return i != -1?fullUrl.substring(0, i):((i = fullUrl.indexOf("?")) != -1?fullUrl.substring(0, i):fullUrl);
    }

    /**
     * 根据园区名，例如"fc"，获取platformId
     * 规则是，将园区名的所有字符转为大写，然后再取每个字符的ASCII码拼接而成
     * @param parkName
     *     园区名
     * @return
     *     platform id
     */
    public static Long getPlatformId(String parkName) {
        String parkNameUpperCase = parkName.toUpperCase();
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < parkNameUpperCase.length(); index ++) {
            stringBuilder.append((int)parkNameUpperCase.charAt(index));
        }
        return Long.valueOf(stringBuilder.toString());
    }

    public static void main(String[] args) {
        System.out.println(getPlatformId("fc"));
    }
}