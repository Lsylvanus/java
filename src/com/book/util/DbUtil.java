package com.book.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库工具类
 * @author Administrator
 *
 */
public class DbUtil {


	private static String dbUrl = "jdbc:mysql://localhost:3306/db_book";
	private static String dbUserName="root";
	private static String dbPassword="chenghai3c";
	private static String jdbcName="com.mysql.jdbc.Driver";
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	
	public Connection getCon()throws Exception{
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUserName,
				dbPassword);
		return con;
	}
	
	/**
	 * 关闭数据库连接
	 * @param connection
	 * @throws Exception
	 */
	public void closeCon(Connection con) throws SQLException {
		if (con!=null) {
			con.close();
		}
	}
	
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
