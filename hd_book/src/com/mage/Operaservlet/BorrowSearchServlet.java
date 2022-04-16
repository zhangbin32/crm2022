package com.mage.Operaservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mage.bean.PageBean;
import com.mage.dao.OperaBookDao;
import com.mage.dao.impl.OperaBookDaoImpl;




@WebServlet("/BorrowSearchServlet")
public class BorrowSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BorrowSearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 1;
		if(request.getParameter("currentPage")!=null) {
			currentPage =Integer.parseInt( request.getParameter("currentPage"));
		}
		//获取查询的内容，该内容可能指向用户名，也可能指向图书名
		String key = request.getParameter("key");
		
		//2. 根据指定的页数，去获取该页的数据回来
		//List<User> --- list.jsp
		OperaBookDao bookService = new OperaBookDaoImpl();
		try {
			PageBean pageBean  = bookService.findBorrowByKey(currentPage,key);
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("search", true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/bookManager/BorrowNote.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
