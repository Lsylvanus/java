package com.book.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.dao.BookDao;
import com.book.model.Book;
import com.book.util.DateUtil;
import com.book.util.DbUtil;
import com.book.util.ResponseUtil;
import com.book.util.StringUtil;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class BookSaveServlet
 */
public class BookSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DbUtil dbUtil = new DbUtil();
	BookDao bookDao = new BookDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookSaveServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		request.setCharacterEncoding("utf-8");
		String bookNO = request.getParameter("bookNO");
		String bookName = request.getParameter("bookName");
		String author = request.getParameter("author");
		String publishDate = request.getParameter("publishDate");
		String price = request.getParameter("price");
		String bookTypeId = request.getParameter("bookTypeId");
		String bookDesc = request.getParameter("bookDesc");
		String bookId = request.getParameter("bookId");

		Book book = null;
		try {
			book = new Book(bookNO, bookName, author, DateUtil.formatString(publishDate, "yyyy-MM-dd"),
					Float.parseFloat(price), Integer.parseInt(bookTypeId), bookDesc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(StringUtil.isNotEmpty(bookId)){
			book.setBookId(Integer.parseInt(bookId));
		}
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int saveNums=0;
			JSONObject result=new JSONObject();
			if(StringUtil.isNotEmpty(bookId)){
				saveNums=bookDao.bookModify(con, book);
			}else{
				saveNums=bookDao.bookAdd(con, book);
			}
			if(saveNums>0){
				result.put("success", "true");
			}else{
				result.put("success", "true");
				result.put("errorMsg", "±£¥Ê ß∞‹");
			}
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
