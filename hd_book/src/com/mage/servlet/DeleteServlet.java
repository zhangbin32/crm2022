package com.mage.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mage.dao.UserDao;
import com.mage.dao.impl.UserDaoImpl;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1. 接收id
			int userid = Integer.parseInt(request.getParameter("Userid"));
			System.out.println("deleteing .....");
			//2. 执行删除
			UserDao service = new UserDaoImpl();
			service.delete(userid);
			System.out.println("deleted .....");
			//3. 跳转到列表页。
			request.getRequestDispatcher("/UserListServlet").forward(request, response);
		}catch (Exception e) {
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
