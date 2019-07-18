
package com.itmayiedu;


import com.alibaba.fastjson.JSONObject;

public class Test001 {
	// 定义了一个json字符串
	static String json = "{\"id\":\"20\",\"name\":\"余胜军\",\"items\":[{\"itemId\":\"20\",\"itemName\":\"每特教育\"},{\"itemId\":\"21\",\"itemName\":\"蚂蚁课堂\"}]}";

	public static void main(String[] args) {
//		// 1.先转换成jsonobject对象
//		JSONObject jsonObject = new JSONObject().parseObject(json);
//		// String id=(String) jsonObject.get("id");
//		String id = jsonObject.getString("id");
//		String name = jsonObject.getString("name");
//		System.out.println("id:" + id + "--name" + name);
//		JSONArray jsonArray = jsonObject.getJSONArray("items");
//		for (int i = 0; i < jsonArray.size(); i++) {
//			JSONObject object = jsonArray.getJSONObject(i);
//			String itemId = object.getString("itemId");
//			String itemName = object.getString("itemName");
//			System.out.println("itemId:" + itemId + "--itemName" + itemName);
//			// JSONObject object=(JSONObject) jsonArray.get(i);
//
//		}
		// json转换对象
		User user = new JSONObject().parseObject(json, User.class);
		System.out.println(user.toString());
	}

}
