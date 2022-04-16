package com.mage.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.mage.bean.Book;
import com.mage.bean.OperaBook;
import com.mage.bean.PageBean;
import com.mage.bean.User;



public interface OperaBookDao {
	void BorrowBooks(Book Book, User User,Date date);
	void ReturnBooks(Book Book, User User,Date date);
	void RenewBook(Book Book, User User,Date date);
	int PAGE_SIZE = 5; //分页显示多少条记录
	List<OperaBook> findAll(int currentPage) throws SQLException;
	PageBean findAlls(int currentPage) throws SQLException;
	List<OperaBook> findOperaByUserid(int userid) throws SQLException;
	//根据记录id username isreturn 查询借阅记录
	List<OperaBook> findOperaByINT(String bookname,String username,boolean isreturn) throws SQLException;
	/**
	 * @param Book
	 * @param User
	 * @return
	 */
	int CountBorrowBooks(Book Book, User User);
	/**
	 * @param User
	 * @return
	 */
	int findCount() throws SQLException;
	//删除借阅记录
	void deleteOperaBooks(String operatid) throws SQLException;
	PageBean findBorrowByKey(int currentPage, String key) throws SQLException;
	List<OperaBook> findBorrowBooksByKey(int currentPage, String key) throws SQLException;
}
