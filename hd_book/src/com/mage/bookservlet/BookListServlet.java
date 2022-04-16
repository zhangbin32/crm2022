package com.mage.bookservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mage.bean.PageBean;
import com.mage.dao.BookDao;
import com.mage.dao.impl.BookDaoImpl;

@WebServlet("/BookListServlet")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1. 获取需要显示的页码数
			int currentPage = 1;
			String Bookname=  request.getParameter("bookname");
			String Booktype=  request.getParameter("booktype");
			if(request.getParameter("currentPage")!=null) {
				currentPage =Integer.parseInt( request.getParameter("currentPage"));
			}
			
			//2. 根据指定的页数，去获取该页的数据回来
			//List<Book> --- list.jsp
			BookDao service = new BookDaoImpl();
			PageBean pageBean= service.findBookByPages(currentPage);
			request.setAttribute("pageBean", pageBean);
			//3. 跳转界面。
			request.getRequestDispatcher("/Book/Super_Book_selectAll.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
