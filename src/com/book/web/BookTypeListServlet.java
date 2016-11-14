package com.book.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.dao.BookTypeDao;
import com.book.model.BookType;
import com.book.model.PageBean;
import com.book.util.DbUtil;
import com.book.util.JsonUtil;
import com.book.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class BookTypeListServlet
 */
public class BookTypeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DbUtil dbUtil=new DbUtil();
	BookTypeDao bookTypeDao=new BookTypeDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookTypeListServlet() {
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
		String page=request.getParameter("page");
		String rows=request.getParameter("rows");
		String bookTypeName=request.getParameter("bookTypeName");
		if(bookTypeName==null){
			bookTypeName="";
		}
		BookType bookType=new BookType();
		bookType.setBookTypeName(bookTypeName);
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Connection con=null;
		try {
			con=dbUtil.getCon();
			JSONObject result=new JSONObject();
			JSONArray jsonArray=JsonUtil.formatRsToJsonArray(bookTypeDao.bookTypeList(con, bookType, pageBean));
			int total=bookTypeDao.bookTypeCount(con, bookType);
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			// TODO: handle exception
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
