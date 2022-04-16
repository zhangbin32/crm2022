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


@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddBookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {

			//1. 获取客户端提交上来的数据
			String bookname = request.getParameter("bookname");
			String author = request.getParameter("author");
			String publish = request.getParameter("publish");
			int bookcount = Integer.parseInt(request.getParameter("bookcount"));
			String booktype = request.getParameter("booktype");
			System.out.println(bookname);
			//2. 添加到数据库
			
			
			Book Book = new Book(0, bookname, publish, bookcount, booktype, author);
			BookDao service = new BookDaoImpl();
			service.insert(Book);
			
			request.getRequestDispatcher("BookListServlet").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
