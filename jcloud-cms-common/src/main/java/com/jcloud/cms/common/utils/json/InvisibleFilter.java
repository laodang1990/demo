package com.jcloud.cms.common.utils.json;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author dyc
 * @date 2015年11月18日 下午4:29:45
 * @Description: TODO
 **/
public class InvisibleFilter extends AbstractMethodFilter{
	@Override
	public boolean applyMethod(final Method method) {
        if (method.isAnnotationPresent(Invisible.class)) {
            Invisible anno = method.getAnnotation(Invisible.class);
            if(null != anno){
            	return true;
            }
        }
        return false;
    }
    
    @Override
	public boolean applyField(final Field field) {
        if (field.isAnnotationPresent(Invisible.class)) {
            Invisible anno = field.getAnnotation(Invisible.class);
            if(null != anno){
            	return true;
            }
        }
        return false;
    }
}
