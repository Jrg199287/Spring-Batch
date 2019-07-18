
package com.itmayiedu;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test004 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		//1.new方式创建对象
//		User user = new User();
		//2.使用java的反射机制创建对象Class.forName("类的完整路径");
		Class<?> forName = Class.forName("com.itmayiedu.User");
		//使用默认无参构造函数创建对象forName.newInstance();使用java的反射机制创建对象
//		User classUser = (User) forName.newInstance();
//		classUser.setId("22");
//		System.out.println(classUser);
		//将构造参数私有化可以禁止反射机制的使用
		//创建带有参的构造函数
		Constructor<?> constructor = forName.getConstructor(String.class,String.class);
		User classUser = (User)constructor.newInstance("12","每特教育");
		System.out.println(classUser.toString());
	}
}
