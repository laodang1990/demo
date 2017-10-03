package com.jcloud.cms.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @author dyc
 * @date 2014��12��30������6:43:25 	
 * @version 1.0
 */
public class MD5Utils {
	 // ȫ������
    private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    public MD5Utils() {
    }

    // ������ʽΪ���ָ��ַ�
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        // System.out.println("iRet="+iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    // ������ʽֻΪ����
    private static String byteToNum(byte bByte) {
        int iRet = bByte;
        System.out.println("iRet1=" + iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        return String.valueOf(iRet);
    }

    // ת���ֽ�����Ϊ16�����ִ�
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }

    public static String GetMD5Code(String strObj) {
        String resultString = null;
        try {
            resultString = new String(strObj);
            MessageDigest md = MessageDigest.getInstance("MD5");
            // md.digest() �ú����ֵΪ��Ź�ϣֵ����byte����
            resultString = byteToString(md.digest(strObj.getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return resultString;
    }

    public static String generateSign(Map paramMap, String secret)
    {
        Set<String> keySet = paramMap.keySet();
        List<String> list = new ArrayList<String>(keySet.size());
        for (String s : keySet) {
            list.add(s);
        }
        Collections.sort(list);
        StringBuffer sb = new StringBuffer(secret);
        for (String s : list) {
            sb.append(s).append(paramMap.get(s));
        }
        sb.append(secret);
        return GetMD5Code(sb.toString());
    }

    public static void main(String[] args) {
    	MD5Utils getMD5 = new MD5Utils();
        System.out.println(GetMD5Code("123456"));
    }
}
