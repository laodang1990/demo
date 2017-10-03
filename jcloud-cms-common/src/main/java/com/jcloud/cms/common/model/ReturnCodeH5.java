/**
 *
 */
package com.jcloud.cms.common.model;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public enum ReturnCodeH5 {

    ERROR_EXCEPTION(-1, " 网络失败"),
    ACTIVE_SUCCESS(0, "成功"),
    ERRoR_DATA_FAILURE(-2, " 返回数据包格式错误"),
    ERROR_DATA_UNZIP(-3, "返回数据包解包失败"),
    ERROR_PARAMS(-4, "输入参数错误"),
    ERROR_KEY_INVALID(0x5e, "pt_key无效"),
    ERROR_KEY_EXPIRE(0x5f,"pt_key过期"),
    ERROR_PSSWORD_UPDATE_EXPIRE(0x60,"因为用户改密码pt_key票过期"),
    ERROR_SAFE_EXPIRE(0x61," 因为安全策略pt_key票过期");

    private static final Logger logger = Logger.getLogger(ReturnCodeH5.class);

    private int code;
    private String msg;

    ReturnCodeH5(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ReturnCodeH5 codeToEnum(int code) {

        ReturnCodeH5[] values = ReturnCodeH5.values();
        for (ReturnCodeH5 returnCode : values) {
            if (returnCode.code == code) {
                return returnCode;
            }
        }
        return ERROR_EXCEPTION;
    }

    public int code() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String msg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, ?> Map() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("code", this.code);
        hashMap.put("msg", this.msg);
        logger.info(hashMap);
        return hashMap;
    }

    public Map<String, ?> Map(int code) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("code", code);
        hashMap.put("msg", this.msg);
        logger.info(hashMap);
        return hashMap;
    }

    public Map<String, ?> Map(Object msg) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("code", this.code);
        hashMap.put("msg", msg);
        logger.info(hashMap);
        return hashMap;
    }

    public Map<String, ?> Map(int code, Object msg) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("code", code);
        hashMap.put("msg", msg);
        logger.info(hashMap);
        return hashMap;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("{\"code\":").append(this.code).append(",");
        sb.append("\"msg\":\"").append(this.msg).append("\"}");

        logger.info(sb.toString());
        return sb.toString();
    }

}
