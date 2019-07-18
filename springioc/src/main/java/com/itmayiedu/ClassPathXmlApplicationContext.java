
/*  
* Copyright @ 2017 com.iflysse.trains  
* spring-ioc 下午11:07:53  
* All right reserved.  
*  
*/

/**  
* @classDesc: 功能描述:()
* @author: 余胜军  
* @createTime: 2017年12月11日 下午11:07:53  
* @version: v1.0  
* @copyright:蚂蚁课堂(每特学院)上海每特教育科技有限公司出品
* @website:www.itmayiedu.com或者www.meiteedu.com
* @weixin:官方微信号 每特学院
* @QQ:644064779  QQ群:116295598
*/

package com.itmayiedu;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.itmayiedu.entity.UserEntity;

public class ClassPathXmlApplicationContext {
	private static String PATH;
	private static String ID;
	private static String CLASS;
	private static String NAME;
	private static String VALUE;

	public void init() {
		ID = "id";
		CLASS = "class";
		NAME = "name";
		VALUE = "value";
	}

	public ClassPathXmlApplicationContext(String path) {
		init();
		// 获取spring读取文件名称
		this.PATH = path;
	}

	public Object getBean(String beanId) throws DocumentException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, NoSuchFieldException, SecurityException {
		// 1、解析xml
		if (StringUtils.isEmpty(beanId)) {
			return null;
		}
		SAXReader saxReader = new SAXReader();
		Document read = saxReader.read(this.getClass().getClassLoader().getResource(PATH));
		Element rootElement = read.getRootElement();
		List<Element> elements = rootElement.elements();
		for (Element element : elements) {
			String id = element.attributeValue(ID);
			if (!beanId.equals(id)) {
				// 结束本次循环
				continue;
			}
			// 2、使用beanid查找对应xml节点，获取class节点属性
			// 从配置文件中获取bean
			String attClass = element.attributeValue(CLASS);
			// 3、使用java的反射机制初始化类
			Class<?> forName = Class.forName(attClass);
			Object newInstance = forName.newInstance();
			// 4、获取属性
			List<Element> sonEle = element.elements();
			for (Element el : sonEle) {
				// 获取配置文件属性名称
				String attField = el.attributeValue(NAME);
				String attFieldValue = el.attributeValue(VALUE);
				Field declaredField = forName.getDeclaredField(attField);
				declaredField.setAccessible(true);
				declaredField.set(newInstance, attFieldValue);
			}
			return newInstance;
		}
		return null;
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, NoSuchFieldException, SecurityException, DocumentException {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserEntity user = (UserEntity) app.getBean("user2");
		System.out.println(user.toString());
	}

}