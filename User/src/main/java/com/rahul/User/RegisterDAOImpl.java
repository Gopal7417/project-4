package com.rahul.User;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import org.json.simple.JSONArray;
import org.json.simple.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;


public class RegisterDAOImpl implements RegisterDAO {
	JdbcTemplate template;
    JSONArray jsray=null;
    
    
	
	public void setTemplate(JdbcTemplate t) {
		template=t;
	}
	public JdbcTemplate getTemplate() {
		return template;
	}
	
	//Method to register the user in database
	public int registerUser(UserModel user){
		
		//prepare the insert statement
	    String qry = "insert into users values(?,?,?,?,?,?,?)";

	    //execute the DML statement
	    int st=template.update(qry, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),user.getLastname(), user.getEmail(), user.getQual(), user.getMobile() });
	    
		return st;
	}
	
	//Method to verify user credentials
	public int validateCredentials(LoginModel lm) {
		
		//get the password for the given user
		String qry = "select password from users where userid=?";
		
		try {
		String pwd = (String)template.queryForObject(qry,new Object[]{lm.getUsername()}, String.class );
		
		//verify the password
		if (pwd != null) {
			if (lm.getPassword().equals(pwd)) {
				return 0;	//success
			}else {
				return 1;	//wrong password
			}
		}else {
			return 2;
		}
		
		}catch(Exception ex) {
			return 2;	//user itself wrong
		}
		
	}
	
	//method to get all users using ResultSet Extractor

/*	public List<UserModel> getAllUsers() {
		String sql = "select stan_name from stations";
		List <UserModel> users = template.query(sql, new UserMapper());
		return users;
	}
	*/
	public List getAllUsers() {
	      String SQL = "select * from stations";
	      List  users = template.query(SQL,new ResultSetExtractor<List>(){
	         
	         public List extractData(
	            ResultSet rs) throws SQLException, DataAccessException {
	            
	            List ulist = new ArrayList();  
	            while(rs.next()){  
	             
	            
	               ulist.add(rs.getString(1));  
	            }  
	            return ulist;  
	         }    	  
	      });
	      return users;
	   }
	
	//Method to register the user in database
	public void addUsers(UsersForm uf){
		
		//iterating through the collection
		
		for(UserModel user : uf.getUsersList()) {
		
			//prepare the insert statement
			String qry = "insert into users values(?,?,?,?,?,?,?)";

			//execute the DML statement
			int st=template.update(qry, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),user.getLastname(), user.getEmail(), user.getQual(), user.getMobile() });
	    
		}
	}
	
	
	/*public List<UserModel> names (String a,String b) {
		
		String sql1 = "select stan_id from stations where stan_name='"+a+"'";
		List <UserModel> stations = template.query(sql1, new UserMapper3());
		
		return stations;
		
		
	}*/
	public JSONArray names() {
		String sql1 = "select * from stations";
		JSONArray stations = template.query(sql1,new ResultSetExtractor<JSONArray>(){
	         
	         public JSONArray extractData(ResultSet rs) throws SQLException, DataAccessException {
	        	 JSONArray json = new JSONArray();
	             ResultSetMetaData metadata = rs.getMetaData();
	             int numColumns = metadata.getColumnCount();
	             while(rs.next())             //iterate rows
	             {
	                 JSONObject obj = new JSONObject();      //extends HashMap
	                 for (int i = 1; i <=numColumns; ++i)           //iterate columns
	                 {
	                     String column_name = metadata.getColumnName(i);
	                     obj.put(column_name, rs.getString(column_name));
	                 }
	                 json.add(obj);
	                

	             }
	             
	             return json;
	   }

});
		
		
		
		
return stations;
	}


}







