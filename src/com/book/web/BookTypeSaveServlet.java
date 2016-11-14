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
import com.book.util.DbUtil;
import com.book.util.ResponseUtil;
import com.book.util.StringUtil;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class BookTypeSaveServlet
 */
public class BookTypeSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DbUtil dbUtil=new DbUtil();
	BookTypeDao bookTypeDao=new BookTypeDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookTypeSaveServlet() {
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
		request.setCharacterEncoding("utf-8");
		String bookTypeName=request.getParameter("bookTypeName");
		String bookTypeDesc=request.getParameter("bookTypeDesc");
		String id=request.getParameter("id");
		BookType bookType=new BookType(bookTypeName, bookTypeDesc);
		if(StringUtil.isNotEmpty(id)){
			bookType.setId(Integer.parseInt(id));
		}
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int saveNums=0;
			JSONObject result=new JSONObject();
			if(StringUtil.isNotEmpty(id)){
				saveNums=bookTypeDao.bookTypeModify(con, bookType);
			}else{
				saveNums=bookTypeDao.bookTypeAdd(con, bookType);
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
