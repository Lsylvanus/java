package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.book.model.Book;
import com.book.model.PageBean;
import com.book.util.StringUtil;
import com.book.util.DateUtil;

/**
 * BookDao Class
 * @author Administrator
 *
 */
public class BookDao {

	/**
	 * 图书添加
	 * @param con
	 * @param book
	 * @return
	 * @throws SQLException
	 */
	public int bookAdd(Connection con,Book book) throws SQLException {
		String sql="insert into t_book values(null,?,?,?,?,?,?,?)";
		PreparedStatement pStatement=con.prepareStatement(sql);
		pStatement.setString(1, book.getBookNO());
		pStatement.setString(2, book.getBookName());
		pStatement.setString(3, book.getAuthor());
		pStatement.setString(4, DateUtil.formatDate(book.getPublishDate(), "yyyy-MM-dd"));
		pStatement.setFloat(5, book.getPrice());
		pStatement.setInt(6, book.getBookTypeId());
		pStatement.setString(7, book.getBookDesc());
		return pStatement.executeUpdate();
	}
	
	/**
	 * 图书数目
	 * @param con
	 * @param book
	 * @return
	 * @throws SQLException 
	 */
	public int bookCount(Connection con,Book book,String publishDate) throws SQLException {
		StringBuffer sBuffer=new StringBuffer("select count(*) as total from t_book tb,t_booktype tby where tb.bookTypeId=tby.id");
		if(StringUtil.isNotEmpty(book.getBookNO())){
			sBuffer.append(" and tb.bookNO like '%"+book.getBookNO()+"%'");
		}
		if (StringUtil.isNotEmpty(book.getBookName())) {
			sBuffer.append(" and tb.bookName like '%"+book.getBookName()+"%'");
		}
		if (StringUtil.isNotEmpty(book.getAuthor())) {
			sBuffer.append(" and tb.author like '%"+book.getAuthor()+"%'");
		}
		if(StringUtil.isNotEmpty(publishDate)){
			sBuffer.append(" and TO_DAYS(tb.publishDate)>=TO_DAYS('"+publishDate+"')");
		}
		if (book.getBookTypeId()!=null && book.getBookTypeId()!=-1) {
			sBuffer.append(" and tb.bookTypeId="+book.getBookTypeId());
		}
		PreparedStatement pStatement=con.prepareStatement(sBuffer.toString());
		ResultSet reSet=pStatement.executeQuery();
		if(reSet.next()){
			return reSet.getInt("total");
		}else{
			return 0;
		}
	}
	
	/**
	 * 图书信息查询
	 * @param con
	 * @param book
	 * @return
	 * @throws SQLException 
	 */
	public ResultSet bookList(Connection con,Book book,PageBean pageBean,String publishDate) throws SQLException {
		StringBuffer sBuffer = new StringBuffer("select * from t_book tb,t_bookType tby where tb.bookTypeId=tby.id");
		if(StringUtil.isNotEmpty(book.getBookNO())){
			sBuffer.append(" and tb.bookNO like '%"+book.getBookNO()+"%'");
		}
		if (StringUtil.isNotEmpty(book.getBookName())) {
			sBuffer.append(" and tb.bookName like '%"+book.getBookName()+"%'");
		}
		if (StringUtil.isNotEmpty(book.getAuthor())) {
			sBuffer.append(" and tb.author like '%"+book.getAuthor()+"%'");
		}
		/*if (StringUtil.isNotEmpty(book.getPrice())) {
			sBuffer.append(" and tb.price = '"+book.getPrice()+"'");
		}*/
		if(StringUtil.isNotEmpty(publishDate)){
			sBuffer.append(" and TO_DAYS(tb.publishDate)>=TO_DAYS('"+publishDate+"')");
		}
		if (book.getBookTypeId()!=null && book.getBookTypeId()!=-1) {
			sBuffer.append(" and tb.bookTypeId="+book.getBookTypeId());
		}
		if(pageBean!=null){
			sBuffer.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		PreparedStatement pStatement=con.prepareStatement(sBuffer.toString());
		return pStatement.executeQuery();
	}
	
	/**
	 * 图书信息删除
	 * @param con
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public int bookDelete(Connection con,String delIds) throws SQLException {
		String sql="delete from t_book where bookId in("+delIds+")";
		PreparedStatement pStatement=con.prepareStatement(sql);
		return pStatement.executeUpdate();
	}
	
	/**
	 * 图书信息修改
	 * @param con
	 * @param book
	 * @return
	 * @throws SQLException
	 */
	public int bookModify(Connection con,Book book) throws SQLException {
		String sql="update t_book set bookNO=?,bookName=?,author=?,publishDate=?,price=?,bookTypeId=?,bookDesc=? where id=?";
		PreparedStatement pStatement=con.prepareStatement(sql);
		pStatement.setString(1, book.getBookNO());
		pStatement.setString(2, book.getBookName());
		pStatement.setString(3, book.getAuthor());
		pStatement.setString(4, DateUtil.formatDate(book.getPublishDate(), "yyyy-MM-dd"));
		pStatement.setFloat(5, book.getPrice());
		pStatement.setInt(6, book.getBookTypeId());
		pStatement.setString(7, book.getBookDesc());
		pStatement.setInt(8, book.getBookId());
		return pStatement.executeUpdate();
	}
	
	/**
	 * 指定图书类别下是否存在图书
	 * @param con
	 * @param bookTypeId
	 * @return
	 * @throws SQLException 
	 */
	public boolean existBookByBookTypeId(Connection con,String bookTypeId) throws SQLException {
		String sql="select * from t_book where bookTypeId=?";
		PreparedStatement pStatement=con.prepareStatement(sql);
		pStatement.setString(1, bookTypeId);
		ResultSet rSet=pStatement.executeQuery();
		if(rSet.next()){
			return true;
		}else{
			return false;
		}
	}
}
