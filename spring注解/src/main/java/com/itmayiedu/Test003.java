
package com.itmayiedu;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

//注解是对应表的关联
@Retention(RetentionPolicy.RUNTIME)
@interface Table {
	String value();
}
// 属性对应注解
@Retention(RetentionPolicy.RUNTIME)
@interface Propety {
	String name();
	int leng() default 0;
}

@Table("itmayiedu_student")
class Student {
	@Propety(name = "student_id", leng = 10)
	private String studentId;
	@Propety(name = "student_name")
	private String studentName;
	@Propety(name = "student_age")
	private String studentAge;
}

public class Test003 {
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> forName = Class.forName("com.itmayiedu.Student");

		// 获取所有当前的方法
		Field[] declaredFields = forName.getDeclaredFields();
		StringBuffer sf = new StringBuffer();
		sf.append(" select ");
		for (int i = 0; i < declaredFields.length; i++) {
			Field field = declaredFields[i];
			//获取属性上的注解
			Propety propety = field.getDeclaredAnnotation(Propety.class);
			sf.append(propety.name());
			if (i < declaredFields.length - 1) {
				sf.append(" , ");
			}
		}
		// 获取类上注解参数
		Table declaredAnnotation = forName.getDeclaredAnnotation(Table.class);
		sf.append(" from  " + declaredAnnotation.value());
		System.out.println(sf.toString());
	}

}
