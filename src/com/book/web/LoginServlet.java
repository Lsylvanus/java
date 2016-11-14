package com.book.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.dao.UserDao;
import com.book.model.User;
import com.book.util.DbUtil;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DbUtil dbUtil=new DbUtil();
	UserDao userDao=new UserDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String userName=request.getParameter("userName");
		String password=request.getParameter("pwd");
		
		User user=new User(userName, password);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			User currentUser=userDao.login(con, user);
			if (currentUser==null) {
				request.setAttribute("error", "用户名或密码错误");
				request.setAttribute("userName", userName);
				request.setAttribute("pwd", password);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else {
				HttpSession session=request.getSession();
				session.setAttribute("currentUser", currentUser);
				response.sendRedirect("main.jsp");
			}
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
