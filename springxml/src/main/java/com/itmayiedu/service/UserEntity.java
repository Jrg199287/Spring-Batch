
package com.itmayiedu.service;

public class UserEntity {
	private String userId;
	private String userName;

	 public UserEntity(){
		 System.out.println("无参构造函数....");
	 }
	
	public String getUserId() {

		return userId;
	}

	public void setUserId(String userId) {

		this.userId = userId;
	}

	public String getUserName() {

		return userName;
	}

	public void setUserName(String userName) {

		this.userName = userName;
	}

}
