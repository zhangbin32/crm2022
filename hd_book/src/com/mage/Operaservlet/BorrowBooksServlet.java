package com.mage.Operaservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mage.bean.Book;
import com.mage.bean.User;
import com.mage.dao.BookDao;
import com.mage.dao.OperaBookDao;
import com.mage.dao.UserDao;
import com.mage.dao.impl.BookDaoImpl;
import com.mage.dao.impl.OperaBookDaoImpl;
import com.mage.dao.impl.UserDaoImpl;


@WebServlet("/BorrowBooksServlet")
public class BorrowBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BorrowBooksServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hehehe");
		try {
			//1.接收id
			int Bookid = Integer.parseInt(request.getParameter("bookid"));
			System.out.println(Bookid);
			//2.查询数据
			BookDao Dao = new BookDaoImpl();
			Book Book = Dao.findBookById(Bookid);
			System.out.println(Book.toString());
			//3.显示数据
			//存数据
			request.setAttribute("Book", Book);
			if(request.getParameter("userid")==null) {
				request.getRequestDispatcher("bookManager/BorrowBook.jsp").forward(request, response);
			}else {
				int userid = Integer.parseInt(request.getParameter("userid"));
				//2.查询数据
				UserDao UserDao = new UserDaoImpl();
				User user = UserDao.findUserById(userid);
				System.out.println(user.toString());
				//3. 显示数据
				//存数据
				request.setAttribute("user", user);
				OperaBookDao bookDao = new OperaBookDaoImpl();
				bookDao.BorrowBooks(Book, user, new Date());
				request.getRequestDispatcher("/BorrowNoteServlet").forward(request, response);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
