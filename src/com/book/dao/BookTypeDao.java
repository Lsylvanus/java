package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.book.model.BookType;
import com.book.model.PageBean;
import com.book.util.StringUtil;

/**
 * BookTypeDao Class
 * @author Administrator
 *
 */
public class BookTypeDao {

//	private static dbUtil dbUtil=new dbUtil();
	
	/**
	 * 图书类别添加
	 * @param con
	 * @param bookType
	 * @return
	 * @throws SQLException 
	 */
	public int bookTypeAdd(Connection con,BookType bookType ) throws SQLException {
		String sql="insert into t_bookType values(null,?,?)";
		PreparedStatement pStatement=con.prepareStatement(sql);
		pStatement.setString(1, bookType.getBookTypeName());
		pStatement.setString(2, bookType.getBookTypeDesc());
		return pStatement.executeUpdate();
	}
	
	/**
	 * 图书类别数目
	 * @param con
	 * @param bookType
	 * @return
	 * @throws SQLException
	 */
	public int bookTypeCount(Connection con,BookType bookType) throws SQLException {
		StringBuffer sbBuffer=new StringBuffer("select count(*) as total from t_booktype");
		if(StringUtil.isNotEmpty(bookType.getBookTypeName())){
			sbBuffer.append(" and bookTypeName like '%"+bookType.getBookTypeName()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sbBuffer.toString().replaceFirst("and", "where"));
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}
	
	/**
	 * 图书类别修改
	 * @param con
	 * @param bookType
	 * @return
	 * @throws SQLException
	 */
	public int bookTypeModify(Connection con,BookType bookType) throws SQLException {
		String sql="update t_bookType set bookTypeName=?,bookTypeDesc=? where id=?";
		PreparedStatement pStatement=con.prepareStatement(sql);
		pStatement.setString(1, bookType.getBookTypeName());
		pStatement.setString(2, bookType.getBookTypeDesc());
		pStatement.setInt(3, bookType.getId());
		return pStatement.executeUpdate();
	}
	
	/**
	 * 图书类别删除
	 * @param con
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public int bookTypeDelete(Connection con,String delIds) throws SQLException {
		String sql="delete from t_bookType where id in("+delIds+")";
		PreparedStatement pStatement=con.prepareStatement(sql);
		return pStatement.executeUpdate();
	}
	
	/**
	 * 查询图书类别集合
	 * @param con
	 * @param bookType
	 * @return
	 * @throws SQLException 
	 */
	public ResultSet bookTypeList(Connection con,BookType bookType,PageBean pageBean) throws SQLException {
		StringBuffer sBuffer=new StringBuffer("select * from t_bookType");
		if (bookType!=null && StringUtil.isNotEmpty(bookType.getBookTypeName())) {
			sBuffer.append(" and bookTypeName like '%"+bookType.getBookTypeName()+"%'");	
		}if(pageBean!=null){
			sBuffer.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
//		PreparedStatement pStatement=con.prepareStatement(sBuffer.toString());
		PreparedStatement pStatement = con.prepareStatement(sBuffer.toString().replaceFirst("and", "where"));
		return pStatement.executeQuery();
	}
}