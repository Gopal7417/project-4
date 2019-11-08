package com.rahul.User;

import java.util.List;

import org.json.simple.JSONArray;

public class UsersForm {

	private List<UserModel> usersList;
	private String one;
	private List<UserModel> namesList;  
	
	private JSONArray are;
private String two;

private String three;

private String four;
	
	public String getFour() {
	return four;
}

public void setFour(String four) {
	this.four = four;
}

	public String getOne() {
		return one;
	}

	public void setOne(String one) {
		this.one = one;
	}

	public String getTwo() {
		return two;
	}

	public void setTwo(String two) {
		this.two = two;
	}



	public List<UserModel> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<UserModel> ul) {
		this.usersList = ul;
	}

	public String getThree() {
		return three;
	}

	public void setThree(String three) {
		this.three = three;
	}

	public List<UserModel> getNamesList() {
		return namesList;
	}

	public void setNamesList(List<UserModel> namesList) {
		this.namesList = namesList;
	}

	public JSONArray getAre() {
		return are;
	}

	public void setAre(JSONArray are) {
		this.are = are;
	}
}