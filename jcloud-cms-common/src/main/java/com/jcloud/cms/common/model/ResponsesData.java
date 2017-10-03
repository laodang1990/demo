package com.jcloud.cms.common.model;

/**
 * @author
 * @date 专用于ipass对接
 * @version 1.0
 */
public class ResponsesData implements java.io.Serializable{

	private static final long serialVersionUID = 7574063090595143619L;

	private int code = ReturnCode.ACTIVE_FAILURE.code();
	private String  msg =  ReturnCode.ACTIVE_FAILURE.msg();
    private Object data;

	public ResponsesData(ReturnCode returnCode) {
		this.code = returnCode.code();
		this.msg = returnCode.msg();
	}

	public void setReturnCode(ReturnCode returnCode) {
		this.code = returnCode.code();
		this.msg = returnCode.msg();
	}

	public int getCode() {
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}


}
