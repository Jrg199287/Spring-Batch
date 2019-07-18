//
//package com.itmayiedu;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//
//public class Test002 {
//
//	public static void main(String[] args) {
//
////		JSONObject root = new JSONObject();
////		root.put("id", "20");
////		root.put("name", "余胜军");
////		JSONArray jsonArray = new JSONArray();
////		JSONObject object1 = new JSONObject();
////		object1.put("itemId", "20");
////		object1.put("itemName", "每特学院");
////		JSONObject object2 = new JSONObject();
////		object2.put("itemId", "20");
////		object2.put("itemName", "每特学院");
////		jsonArray.add(object1);
////		jsonArray.add(object2);
////		root.put("items", jsonArray);
////		System.out.println(root.toJSONString());
//		// 使用实体类封装json字符串
//		User user = new User();
//		user.setId("20");
//		user.setName("余胜军");
//		List<Item> listItem = new ArrayList<Item>();
//		Item item1 = new Item();
//		item1.setItemId("20");
//		item1.setItemName("每特教育");
//		Item item2 = new Item();
//		item2.setItemId("21");
//		item2.setItemName("每特学院");
//		listItem.add(item1);
//		listItem.add(item2);
//		user.setItems(listItem);
//		System.out.println(new JSONObject().toJSONString(user));
//	}
//
//}
