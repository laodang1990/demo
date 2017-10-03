package com.jcloud.cms.common.model;

/**
 * @author dyc
 * @date 2015年11月13日上午11:01:03 	
 * @version 1.0
 */
public class ResponsesDT implements java.io.Serializable{

	private static final long serialVersionUID = 7574063090595143612L;

	private int code = ReturnCode.ACTIVE_FAILURE.code();
    private String  msg =  ReturnCode.ACTIVE_FAILURE.msg();
    private Object result;

	public ResponsesDT(ReturnCode returnCode) {
		this.code = returnCode.code();
		this.msg = returnCode.msg();
	}

	public ResponsesDT(ReturnCodeH5 returnCode) {
		this.code = returnCode.code();
		this.msg = returnCode.msg();
	}
	public void setReturnCode(ReturnCodeH5 returnCode) {
		this.code = returnCode.code();
		this.msg = returnCode.msg();
	}
	public void setReturnCode(ReturnCode returnCode) {
		this.code = returnCode.code();
		this.msg = returnCode.msg();
	}

	public ReturnCode nowReturnCode() {// 此处不能写getxx,会被spring 识别然后返回出去
		return ReturnCode.codeToEnum(code);
	}

	public ResponsesDT(int code) {
		this.code = code;
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

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResponsesDT [code=").append(code).append(", msg=")
				.append(msg).append(", result=").append(result).append("]");
		return builder.toString();
	}
    
}
