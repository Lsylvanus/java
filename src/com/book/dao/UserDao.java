package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.book.model.User;

/**
 * UserDao Class
 * @author Administrator
 *
 */
public class UserDao {

	/**
	 * µÇÂ¼ÑéÖ¤
	 * @param con
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public User login(Connection con,User user) throws SQLException{
		User reUser=null;
		String sql="select * from t_user where userName=? and passWord=?";
		PreparedStatement pStatement=con.prepareStatement(sql);
		pStatement.setString(1, user.getUserName());
		pStatement.setString(2, user.getPassword());
		ResultSet reSet=pStatement.executeQuery();
		if (reSet.next()) {
			reUser=new User();
			reUser.setId(reSet.getInt("id"));
			reUser.setUserName(reSet.getString("userName"));
			reUser.setPassword(reSet.getString("passWord"));
		}
		return reUser;
	}
}
