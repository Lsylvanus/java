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
import com.book.model.PageBean;
import com.book.util.DbUtil;
import com.book.util.JsonUtil;
import com.book.util.ResponseUtil;
import com.book.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class BookListServlet
 */
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DbUtil dbUtil=new DbUtil();
	BookDao bookDao=new BookDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String bookNO=request.getParameter("bookNO");
		String bookName=request.getParameter("bookName");
		String author=request.getParameter("author");
		String publishDate=request.getParameter("publishDate");
		@SuppressWarnings("unused")
		String price=request.getParameter("price");
		String bookTypeId=request.getParameter("bookTypeId");
		String bookDesc=request.getParameter("bookDesc");
		
		String page=request.getParameter("page");
		String rows=request.getParameter("rows");
		
		Book book=new Book();
		if(bookNO!=null){
			book.setBookNO(bookNO);
			book.setBookName(bookName);
			book.setAuthor(author);
			book.setBookDesc(bookDesc);
			if(StringUtil.isNotEmpty(bookTypeId)){
				book.setBookTypeId(Integer.parseInt(bookTypeId));
			}
		}
	
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Connection con=null;
		try{
			con=dbUtil.getCon();
			JSONObject result=new JSONObject();
			JSONArray jsonArray=JsonUtil.formatRsToJsonArray(bookDao.bookList(con, book, pageBean, publishDate));
			int total=bookDao.bookCount(con, book, publishDate);
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(response, result);
		}catch(Exception e){
			e.printStackTrace();
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
