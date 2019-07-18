
package com.itmayiedu;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test005 {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException,
			InstantiationException, IllegalAccessException {

		// 1.使用java的反射机制 获取的类的所有属性 方法 并且为私有属性赋值
		Class<?> forName = Class.forName("com.itmayiedu.User");
		// 2.获取到当前类的所有属性
		// Field[] declaredFields = forName.getDeclaredFields();
		// for (Field field : declaredFields) {
		// System.out.println(field.getName());
		// }
		// //3.获取当前类的所有的方法
		// Method[] declaredMethods = forName.getDeclaredMethods();
		// for (Method method : declaredMethods) {
		// System.out.println(method.getName());
		// }
		// 4.使用java的反射机制给私有属性赋值
		Object newInstance = forName.newInstance();
		Field fieldId = forName.getDeclaredField("id");
		//允许反射操作私有属性
		fieldId.setAccessible(true);
		fieldId.set(newInstance, "20");
		Field fieldName = forName.getDeclaredField("name");
		fieldName.setAccessible(true);
		fieldName.set(newInstance, "余胜军");
	
		User user = (User) newInstance;
		System.out.println(user.toString());
	}
}
