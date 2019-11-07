package Happy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;


public class DaoImpl implements Dao {
JdbcTemplate template;
	

	public void setTemplate(JdbcTemplate t) {
		template=t;
	}
	public JdbcTemplate getTemplate() {
		return template;
	}
	
	//Method to register the user in database
	public int registerUser(UserModel user){
		
		//prepare the insert statement
	    String qry = "insert into bususer values(?,?)";

	    //execute the DML statement
	    int st=template.update(qry, new Object[] { user.getName(), user.getPsd() });
	    
		return st;
	}
	
	public int loginUser(UserModel u)
	{
String qry = "select pswd from bususer where userid=?";
		
		try {
		String pwd = (String)template.queryForObject(qry,new Object[]{u.getName()}, String.class );
		
		//verify the password
		if (pwd != null) {
			if (u.getPsd().equals(pwd)) {
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

	public int loginadmin(UserModel u)
	{
String qry = "select password from admindetails where userid=?";
		
		try {
		String pwd = (String)template.queryForObject(qry,new Object[]{u.getName()}, String.class );
		
		//verify the password
		if (pwd != null) {
			if (u.getPsd().equals(pwd)) {
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
	
	
	public List<BusModel> getBustypes()
	{
		 String SQL = "select * from bustypes";
		    List <BusModel> buses = template.query(SQL,new ResultSetExtractor<List<BusModel>>(){
		       
		       public List<BusModel> extractData( ResultSet rs) throws SQLException, DataAccessException {
		         
		          
		          List<BusModel> ulist = new ArrayList<BusModel>();  
		          while(rs.next()){  
		        	  BusModel b = new BusModel();
		            b.setBustypeId(rs.getString("BSTY_ID"));
		             b.setBustype(rs.getString("BSTY_TITLE"));
		            ulist.add(b);
		             
		          }  
		          return ulist;  
		       }    	  
		    });
		    return buses;
	}
	
	public List<BusModel> getStation()
	{
		 String SQL = "select stan_name,stan_id from stations";
		 List<BusModel> buses = template.query(SQL,new ResultSetExtractor<List<BusModel>>(){
		       
		       public List<BusModel> extractData( ResultSet rs) throws SQLException, DataAccessException {
		         
		          
		    	   List<BusModel> ulist = new ArrayList<BusModel>();  
		          while(rs.next()){  
		        	  BusModel b = new BusModel();
		           //b.setBustypeId(rs.getString(1));
		        	  b.setFstanid(rs.getString("stan_id"));
			            b. setTstanid(rs.getString("stan_id"));
		            b.setFstation(rs.getString("STAN_NAME"));
		            b.setTstation(rs.getString("STAN_NAME"));
		           // System.out.println(b);
		        	  
		             ulist.add(b);  
		          }  
		          return ulist;  
		       }    	  
		    });
		    return buses;
	}
	public List<BusModel> getRegnos()
	{
		 String SQL = "select * from buses";
		 List<BusModel> buses = template.query(SQL,new ResultSetExtractor<List<BusModel>>(){
		       
		       public List<BusModel> extractData( ResultSet rs) throws SQLException, DataAccessException {
		         
		          
		    	   List<BusModel> ulist = new ArrayList<BusModel>();  
		          while(rs.next()){  
		        	  BusModel b = new BusModel();
		           //b.setBustypeId(rs.getString(1));
		        	  
		            b.setRegno(rs.getString("BUS_REGNO"));
		           
		           // System.out.println(b);
		        	  
		             ulist.add(b);  
		          }  
		          return ulist;  
		       }    	  
		    });
		    return buses;
	}
	
	
	
}
