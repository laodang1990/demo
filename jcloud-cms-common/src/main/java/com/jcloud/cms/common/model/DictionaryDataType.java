package com.jcloud.cms.common.model;

public enum DictionaryDataType {
	REPAIR_TYPE(5l, "报修类型"),
    BOOK_TYPE(3l, "预约项目"),
    TIME_TYPE(4l, "时间段类型");
    private long code;
    private String msg;
    DictionaryDataType(long code,String msg){
    	this.code=code;
    	this.msg=msg;
    }
	public long getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
    
}
