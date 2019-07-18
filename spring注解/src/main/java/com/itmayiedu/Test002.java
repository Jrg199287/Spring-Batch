
package com.itmayiedu;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//这是注解 使用@interface 为注解类
//@Target访问权限
@Target(value = { ElementType.METHOD, ElementType.TYPE, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@interface TestAnnotaion {
     int beanId() default 0 ;//可以不传参数 默认为0
     String className() default ""; // 可以不传参数 默认为孔
     String[] arrArry()  ;
}

@TestAnnotaion(arrArry={"11","0022"})
public class Test002 {

@TestAnnotaion(beanId=2,className="com.itmayiedu",arrArry={"222","3233"})
	private String name;


	public void add() {
	}

}
