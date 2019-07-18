
package com.itmayiedu;

import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test003 {
	public static void main(String[] args) throws DocumentException {
		//1.获取到读取对象
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read("f:\\student.xml");
		Element rootElement = document.getRootElement();
		getNodes(rootElement);
	}
	static public void getNodes(Element rootElement){
		String name = rootElement.getName();
		System.out.println("节点名称:"+name);
		//获取节点属性
		List<Attribute> attributes = rootElement.attributes();
		for (Attribute attribute : attributes) {
			System.out.println("属性名称:"+attribute.getName()+",属性value"+attribute.getValue());
		}
		String value=rootElement.getTextTrim();
		if(!value.equals("")){
			System.out.println("节点value"+value);
		}
		//判断是否有下一个节点
		Iterator<Element> elementIterator = rootElement.elementIterator();
		while (elementIterator.hasNext()) {
			Element next = elementIterator.next();
			getNodes(next);
		}
	}
}
