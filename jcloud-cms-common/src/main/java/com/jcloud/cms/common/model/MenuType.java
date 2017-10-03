package com.jcloud.cms.common.model;

/**
 * @author dyc
 * @date 2015年7月24日下午4:45:37 	
 * @version 1.0
 */
public class MenuType {
	private String message = "Hello from ToyTool1111!";  
	  
    public String getMessage()  
    {  
        return message;  
    }  
  
    public void setMessage(String m)  
    {  
        message = m;  
    }  
  
    /** To test exception handling in templates. */  
    public boolean whine() {  
        throw new IllegalArgumentException();  
    }  
}
