package com.jcloud.cms.common.model;

import com.jcloud.cms.common.exception.ExceptionEnums;

/**
 * @Description 错误码枚举类 errorCode
 * 
 * 1-安全校验错误:
 * 
 * 2-业务逻辑错误； 
 * 		20-用户注册登录、用户信息错误; 
 * 		21-购买、订单信息错误; 
 * 		22-设备等信息错误; 
 * 		23-版本、反馈等错误;
 * 
 * 3-系统网络错误；
 * 
 * @date 2014-4-23 下午02:20:48
 * @author dyc
 */
public enum ErrorCodes implements ExceptionEnums {
	
	ACTIVE_EXCEPTION(-1, "异常"),
    ACTIVE_SUCCESS(0, "成功"),
    ACTIVE_FAILURE(1, "失败"),
    ERROR_PARAMS_NOT_NULL(2, "参数不能为空"),
    ERROR_PARAMS(400, "请求参数错误"),
    ERROR_AUTH(401, "无权限"),
    ERROR_RESOURCES(404, "请求资源不存在"),
    ERROR_SERVER(503, "系统异常"),
    ERROR_NO_LOGIN(1010, "用户未登录"),
    ERROR_USER_COUNT(1012, "您的积分不足"),
    ERROR_USER_COUNT_ALL(1022, "您达到30积分才能领取该商品"),
    ERROR_USER_INFO(1013, "您的资料不全"),
    ERROR_LOGIN_TIMEOUT(1011, "登录用户超时，请重新登录"),
    ERROR_USER_NONE(1009, "用户不存在"),
    ERROR_DEVICE_NULL(1009, "设备编号为空"),
    ERROR_USER_AGENT(1013, "user-agent 请求参数错误"),
    ERROR_PRODUCT_FAILURE(1017, "查询商品数据为空"),
    ERROR_PRODUCT_REP(1021, "您参加过当前活动"),
    ERROR_PRODUCT_DATA(1020, "不在活动时间范围"),
    ERROR_PRODUCT_NUM(1016, "该商品数量不足"),
    ERROR_PRODUCT_COMPLETE(1022, "该活动已开奖"),
    ERROR_UPDATE_FAILURE(1018, "操作失败，请稍后再试"),
    ERROR_INSERT_FAILURE(1016, "数据插入异常"),
    ERROR_SELECT_FAILURE(1019, "数据查询异常"),
    ERROR_NO_RECORD(2001, "查询结果为空"),
    ERROR_COUNT_TOO_LONG(2002, "添加失败,请注意添加规则, 例如：最多只能添加 6 个"),
    ERROR_NO_PIC(2003, "请上传图片.."),
    ERROR_PIC_TYPE(2004, "上传图片仅支持png、jpg、jpeg图片格式"),
    ERROR_PIC_SIZE(2005, "上传图片最大为1M"),
    ERROR_PIC_UPLOAD_IO(2006, "图片上传网络异常"),
    ERROR_PRODUCT_STATUS(3001, "该商品不可开奖");
	

	private int code;
	private String attach;

	ErrorCodes(int code, String attache) {
	   this.code = code;
	   this.attach = attache;
    }

	public int getCode() {
		return code;
	}

	public String getAttach() {
		return attach;
	}
}
