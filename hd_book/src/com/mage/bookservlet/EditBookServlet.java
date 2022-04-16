package com.mage.bookservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mage.bean.Book;
import com.mage.dao.BookDao;
import com.mage.dao.impl.BookDaoImpl;


/**
 * Servlet implementation class EditBookServlet
 */
@WebServlet("/EditBookServlet")
public class EditBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditBookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1. 接收id
			int Bookid = Integer.parseInt(request.getParameter("bookid"));
			System.out.println(Bookid);
			//2. 查询数据
			BookDao service = new BookDaoImpl();
			Book Book = service.findBookById(Bookid);
			//3. 显示数据
			//存数据
			request.setAttribute("Book", Book);
			//跳转
			request.getRequestDispatcher("Book/UpdateBook.jsp").forward(request, response);
			
		}catch (Exception e) {
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
