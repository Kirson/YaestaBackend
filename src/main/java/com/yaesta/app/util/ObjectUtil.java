package com.yaesta.app.util;

import java.lang.reflect.Field;

public class ObjectUtil {

	
	public static Object replaceNullString(Object obj){
	
		Class<?> c = obj.getClass();
		
		for(Field f:c.getDeclaredFields()){
			if(f.getType().equals(String.class)){
               try {
            	   f.setAccessible(true);
            	   Object value = f.get(obj);
            	   if(value==null){
            		   f.set(obj, "");
            	   }
				
               } catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            }
		}
		
		return obj;
	}
}
