package com.rahul.User;
import java.util.List;

import org.json.simple.JSONArray;
public interface RegisterDAO {
	public int registerUser(UserModel um);
	public int validateCredentials(LoginModel lm);
	public List<UserModel> getAllUsers();
	public void addUsers(UsersForm uf);
	public JSONArray names();
}
