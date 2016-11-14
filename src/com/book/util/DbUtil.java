package com.book.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ���ݿ⹤����
 * @author Administrator
 *
 */
public class DbUtil {


	private static String dbUrl = "jdbc:mysql://localhost:3306/db_book";
	private static String dbUserName="root";
	private static String dbPassword="chenghai3c";
	private static String jdbcName="com.mysql.jdbc.Driver";
	
	/**
	 * ��ȡ���ݿ�����
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
	 * �ر����ݿ�����
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
			System.out.println("���ݿ����ӳɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
