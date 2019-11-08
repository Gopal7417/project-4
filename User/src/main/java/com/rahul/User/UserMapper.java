package com.rahul.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<UserModel> {
   public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
       UserModel usr = new UserModel();
       usr.setUsername(rs.getString(1));

     
      return usr;
   }
}