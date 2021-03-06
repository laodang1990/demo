package com.jcloud.cms.common.utils.json;

import net.sf.json.util.PropertyFilter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author dyc
 * @date 2015年11月18日 下午4:30:48
 * @Description: TODO
 **/
public abstract class AbstractMethodFilter implements PropertyFilter{
	// 这个方法留给子类实现，以便适应不同的过滤需求
    public abstract boolean applyMethod(final Method method);
    
 // 这个方法留给子类实现，以便适应不同的过滤需求
    public abstract boolean applyField(final Field field);

    @Override
	public boolean apply(final Object source, final String name, final Object value) {
        if (source instanceof Map) {
            return false;
        }
        String propName = name.substring(0, 1).toUpperCase() + name.substring(1);
        Class<? extends Object> clz = source.getClass();
        String methodName = "get" + propName;
        Method method = null;
        
        try {
        	Field field =  clz.getDeclaredField(name);
        	if(applyField(field)){
        		return true;
        	}
		} catch (SecurityException e) {
		} catch (NoSuchFieldException e) {
		}
        
        try {
            method = clz.getMethod(methodName, (Class[]) null);   // 寻找属性的get方法
        } catch (NoSuchMethodException nsme) {
            String methodName2 =  "is" + propName;                // 也许是个is方法
            try {
                method = clz.getMethod(methodName2, (Class[]) null);
            } catch (NoSuchMethodException ne) {
                // 没有找到属性的get或者is方法，打印错误，返回true
                System.err.println("No such methods: " + methodName + " or " + methodName2);
                return true;
            }
        }
        return applyMethod(method);
    }
}
