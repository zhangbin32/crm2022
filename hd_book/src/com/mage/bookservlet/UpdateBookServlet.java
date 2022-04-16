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



@WebServlet("/UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateBookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			//1. 获取客户端提交上来的数据
			int Bookid = Integer.parseInt(request.getParameter("bookid"));
			String Bookname = request.getParameter("bookname");
			String publish = request.getParameter("publish");
			int bookcount = Integer.parseInt(request.getParameter("bookcount"));
			String author = request.getParameter("author");
			String Booktype = request.getParameter("booktype");;
			//2. 添加到数据库
			
			Book Book = new Book(Bookid, Bookname, publish, bookcount, Booktype, author);
			BookDao service = new BookDaoImpl();
			service.update(Book);
			
			request.getRequestDispatcher("BookListServlet").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
