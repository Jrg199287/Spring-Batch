
package com.itmayiedu.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("resource")
public class Main {

	public static void main(String[] args) {
        //1.读取springxml配置
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		//2.获取bean对象
		UserEntity userEntity = (UserEntity) classPathXmlApplicationContext.getBean("user1");
		System.out.println(userEntity.getUserId()+"----"+userEntity.getUserName());
	}

}
