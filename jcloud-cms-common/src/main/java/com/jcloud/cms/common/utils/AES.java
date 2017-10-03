package com.jcloud.cms.common.utils;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Create with Intellij IDEA
 * Author dangyuanchao
 * Date 2015/12/317:32
 */
public class AES {

    private static int length = 128;

    /**
     * 加密
     *
     * @param content  需要加密的内容
     * @param password 加密密码
     * @return
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws UnsupportedEncodingException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */

    private static byte[] encrypt(String content, String password)


            throws Exception {


        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(password.getBytes());


        kgen.init(length, secureRandom);


        SecretKey secretKey = kgen.generateKey();


        byte[] enCodeFormat = secretKey.getEncoded();


        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");


        Cipher cipher = Cipher.getInstance("AES");// 创建密码器


        byte[] byteContent = content.getBytes("utf-8");


        cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化


        byte[] result = cipher.doFinal(byteContent);


        return result; // 加密


    }


    /**
     * 解密
     *
     * @param content  待解密内容
     * @param password 解密密钥
     * @return
     */

    private static byte[] decrypt(byte[] content, String password)


            throws Exception {


        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(password.getBytes());


        kgen.init(length, secureRandom);


        SecretKey secretKey = kgen.generateKey();


        byte[] enCodeFormat = secretKey.getEncoded();


        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");


        Cipher cipher = Cipher.getInstance("AES");// 创建密码器


        cipher.init(Cipher.DECRYPT_MODE, key);// 初始化


        byte[] result = cipher.doFinal(content);


        return result; // 加密


    }

//

    /**
     * //
     * 将二进制转换成16进制
     * //
     * <p/>
     * //
     *
     * @param buf //
     * @return //
     */
//
    public static String parseByte2HexStr(byte buf[]) {
//

        StringBuffer sb = new StringBuffer();
//

        for (int i = 0; i < buf.length; i++) {
//


            String hex = Integer.toHexString(buf[i] & 0xFF);
//


            if (hex.length() == 1) {
//


                hex = '0' + hex;
//


            }
//


            sb.append(hex.toUpperCase());
//

        }
//

        return sb.toString();
//
    }
//
//

    /**
     * //
     * 将16进制转换为二进制
     * //
     * <p/>
     * //
     *
     * @param hexStr //
     * @return //
     */
//
    public static byte[] parseHexStr2Byte(String hexStr) {
//

        if (hexStr.length() < 1)
//


            return null;
//

        byte[] result = new byte[hexStr.length() / 2];
//

        for (int i = 0; i < hexStr.length() / 2; i++) {
//


            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
//


            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
//


                    16);
//


            result[i] = (byte) (high * 16 + low);
//

        }
//

        return result;
//
    }


    /**
     * 加密
     *
     * @param content  需要加密的内容
     * @param password 加密密码
     * @return
     */

    public static byte[] encrypt2(String content, String password) {


        try {


            SecretKeySpec key = new SecretKeySpec(password.getBytes(), "AES");


            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");


            byte[] byteContent = content.getBytes("utf-8");


            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化


            byte[] result = cipher.doFinal(byteContent);


            return result; // 加密


        } catch (NoSuchAlgorithmException e) {


            e.printStackTrace();


        } catch (NoSuchPaddingException e) {


            e.printStackTrace();


        } catch (InvalidKeyException e) {


            e.printStackTrace();


        } catch (UnsupportedEncodingException e) {


            e.printStackTrace();


        } catch (IllegalBlockSizeException e) {


            e.printStackTrace();


        } catch (BadPaddingException e) {


            e.printStackTrace();


        }


        return null;

    }


    public static String encrypt2Str(String content, String password) throws Exception {


        byte[] encryptResult = encrypt(content, password);


        return BASE64.encode(encryptResult);

    }
    public static String encrypt2Hex(String content, String password) throws Exception {
        byte[] encryptResult = encrypt(content, password);
        return  parseByte2HexStr(encryptResult);
    }


    public static String decrypt2Str(String content, String password) throws Exception {
        byte[] decryptResult = decrypt(BASE64.decode(content), password);
        return new String(decryptResult, "UTF-8");
    }
    public static String decrypt2Hex(String content, String password) throws Exception {
        byte[] decryptResult = decrypt(parseHexStr2Byte(content), password);
        return new String(decryptResult,"UTF-8");
    }

    public static void main(String[] args) throws Exception {
//        String content ="0E82DF69A97DAC569B0DB5DD90A94C0337AFF732B3F1BA8E3906EC49DDB13A93647190A1591B2390C1287A34C251B91B058EF4E3478432A0C5BF52E8C27F259010E4A28705E420128281F1E2AE8B9BC3F2247307E18DC95CEE68BC615A6A34820C5178ED809B7D5EA2014A076C87BBF5DB84781E7E291EE71600A132BD29C1C0A63609E4803AA35FF5D818B05AC38EA5";
        String content ="100";
        String password ="visit";
// 加密
        System.out.println("加密前："+ content);
        String tt4 = encrypt2Hex(content, password);
        System.out.println(new String(tt4));
// 解密
        String d = decrypt2Hex(tt4, password);
        System.out.println("解密后："+ d);
        //System.out.println("加密前：" + content);
        //String tt4 = encrypt2Str(content, password);
        //System.out.println(new String(tt4));
        // 解密
        //String d = decrypt2Str("eHxK/mXAPiHC/RkBz+9B6RmQamWcCS8wUOUgI8siPMln8FIy6FV9AzgJrFFWM3Bmrkrm4Rb9hciM5wJ52s2gknmu/DokF3I2ivEOoBaN9Vdq1Jd9d53fWJktU+ySVYBm20hsTbeRTk4/ZpAkPuGimg2DuJG3jFmu2Fx/q0DVxBobR8cJoIXAWE3iVaLcTG9I", password);
        //System.out.println("解密后：" + d);
    }

}

