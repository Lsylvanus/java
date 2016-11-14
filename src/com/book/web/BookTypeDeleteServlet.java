package com.book.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.dao.BookDao;
import com.book.dao.BookTypeDao;
import com.book.util.DbUtil;
import com.book.util.ResponseUtil;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class BookTypeDeleteServlet
 */
public class BookTypeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DbUtil dbUtil=new DbUtil();
	BookDao bookDao=new BookDao();
	BookTypeDao bookTypeDao=new BookTypeDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookTypeDeleteServlet() {
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
		String delIds=request.getParameter("delIds");
		Connection con=null;
		try {
			con=dbUtil.getCon();
			JSONObject result=new JSONObject();
			String str[]=delIds.split(",");
			for(int i=0;i<str.length;i++){
				boolean f=bookDao.existBookByBookTypeId(con, str[i]);
				if(f){
					result.put("errorIndex", i);
					result.put("errorMsg", "该图书类别下存在图书，不能删除！");
					ResponseUtil.write(response, result);
					return;
				}
			}
			int delNums=bookTypeDao.bookTypeDelete(con, delIds);
			if(delNums>0){
				result.put("success", "true");
				result.put("delNums", delNums);
			}else{
				result.put("errorMsg", "删除失败");
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
