package com.rahul.User;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.*;
import java.util.*;


public class uro {
	/*JdbcTemplate template;
	public void setTemplate(JdbcTemplate t) {
		template=t;
	}
	public JdbcTemplate getTemplate() {
		return template;
	}
	
	
	 public  JSONArray convertResultSetToJson(ResultSet resultSet) throws Exception
	    {
	        JSONArray json = new JSONArray();
	        ResultSetMetaData metadata = resultSet.getMetaData();
	        int numColumns = metadata.getColumnCount();
	        while(resultSet.next())             //iterate rows
	        {
	            JSONObject obj = new JSONObject();      //extends HashMap
	            for (int i = 1; i <=numColumns; ++i)           //iterate columns
	            {
	                String column_name = metadata.getColumnName(i);
	                obj.put(column_name, resultSet.getString(column_name));
	            }
	            json.add(obj);
	           

	        }
	        
	        return json;//.toJSONString();
	    }
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


	
	public static void main(String args[]){
		JSONArray jsray=null;
		try{
			  Class.forName("oracle.jdbc.driver.OracleDriver");
	           Connection  cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");			
         String qry="select * from stations";
		Statement st = cn.createStatement();
		ResultSet rs = st.executeQuery(qry);
		uro u = new uro();
		  jsray=u.convertResultSetToJson(rs);
		  System.out.println(jsray);
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		}
		}
*/
}


