package com.jcloud.cms.common.utils.json;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.util.Date;

/**
 * @author dyc
 * @date 2015年11月18日 下午4:26:12
 * @Description:  Java转json串时,将Date及其子类类型的值转换为long型.<br/>
 * 具体转换需在JsonConfig中设置.<br/>
 * JsonConfig中必须注册具体的类，不能注册父类或者接口.<br/>
 * <p>
 * 		JsonConfig jcg = new JsonConfig();
 * 		jcg.registerJsonValueProcessor(java.sql.Timestamp.class, jsonValueProcessor);
		jcg.registerJsonValueProcessor(java.sql.Date.class, jsonValueProcessor);
		jcg.registerJsonValueProcessor(java.util.Date.class, jsonValueProcessor);
 * </p>
 **/
public class DateJsonValueProcessor implements JsonValueProcessor{
	@Override
	public Object processArrayValue(Object value, JsonConfig arg1) {
		if(null == value){
			return "";
		}
		if (value instanceof Date) {
			return ((Date)value).getTime();
		}
		return value;
	}

	@Override
	public Object processObjectValue(String arg0, Object value, JsonConfig arg2) {
		if(null == value){
			return "";
		}
		if (value instanceof Date) {
			return ((Date)value).getTime();
		}
		return value;
	}
}
