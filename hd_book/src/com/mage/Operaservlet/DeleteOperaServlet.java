package com.mage.Operaservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mage.dao.OperaBookDao;
import com.mage.dao.impl.OperaBookDaoImpl;


@WebServlet("/DeleteOperaServlet")
public class DeleteOperaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteOperaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1. 接收id
			String Operaid = request.getParameter("Operaid");
			System.out.println("要删除的记录ID"+Operaid);
			//2. 执行删除
			OperaBookDao service = new OperaBookDaoImpl();
			service.deleteOperaBooks(Operaid);
			//3. 跳转到列表页。
			request.getRequestDispatcher("/BorrowNoteServlet").forward(request, response);
		}catch (Exception e) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
