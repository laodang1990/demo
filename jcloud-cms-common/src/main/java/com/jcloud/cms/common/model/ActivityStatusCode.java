/**
 *
 */
package com.jcloud.cms.common.model;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * 活动状态枚举类
 *                       
 * @Filename: ActivityStatusCode.java
 * @Description: 
 * @Version: 1.0
 * @Author: yangzhao
 * @Email: 2212691977@qq.com
 * @History:<br>
 *
 */
public enum ActivityStatusCode {

	// 异常情况
	ACTIVE_STATUS_EXCEPTION(-1, "异常"),
    // 未开始的启用状态活动
    ACTIVITY_OPEN_BEFORE(11,"未开始的启用状态活动"),
    // 进行中的启用状态活动
    ACTIVITY_OPEN_IN(12,"进行中的启用状态活动"),
    // 已结束的启用状态活动
    ACTIVITY_OPEN_AFTER(13,"已结束的启用状态活动"),
    // 未开始的终止状态活动
    ACTIVITY_PAUSE_BEFORE(21,"未开始的终止状态活动"),
    // 进行中的终止状态活动
    ACTIVITY_PAUSE_IN(22,"进行中的终止状态活动"),
    // 已结束的终止状态活动
    ACTIVITY_PAUSE_AFTER(23,"已结束的终止状态活动");


    private static final Logger logger = Logger.getLogger(ActivityStatusCode.class);

    private int code;
    private String msg;

    ActivityStatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ActivityStatusCode codeToEnum(int code) {

    	ActivityStatusCode[] values = ActivityStatusCode.values();
        for (ActivityStatusCode activityStatusCode : values) {
            if (activityStatusCode.code == code) {
                return activityStatusCode;
            }
        }
        return ACTIVE_STATUS_EXCEPTION;
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
