package com.jcloud.cms.common.exception;

/**
 * @author dyc
 * @date 2015年7月22日下午4:24:35 	
 * @version 1.0
 * @category 监听数据库异常
 */
public class ServiceException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private ExceptionEnums exceptionEnums;
	
	public ServiceException(ExceptionEnums exceptionEnums){
		this.exceptionEnums = exceptionEnums;
	}
	
	public ExceptionEnums getExceptionEnums() {
		return exceptionEnums;
	}
}
