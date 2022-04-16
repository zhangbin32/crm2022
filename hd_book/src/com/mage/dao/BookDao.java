package com.mage.dao;

import java.sql.SQLException;
import java.util.List;

import com.mage.bean.Book;
import com.mage.bean.PageBean;



public interface BookDao {
	int PAGE_SIZE = 5; //每页显示多少条记录
	/**
	 * 查询当页的用户数
	 * @param currentPage
	 * @return
	 * @throws SQLException
	 */
	List<Book> findBookByPage(int currentPage) throws SQLException;
	PageBean findBookByPages(int currentPage) throws SQLException;
	List<Book> findAll()  throws SQLException ;
	/**
	 * 添加用户
	 * @param Book 要添加到数据库的用户对象
	 * @throws SQLException
	 */
	void insert(Book Book) throws SQLException ;
	/**
	 *  模糊查询
	 * @param Bookname
	 * @param Booktype
	 * @return
	 * @throws SQLException
	 */
	List<Book> searchBook(String Bookname,String Booktype) throws SQLException ;
	/**
	 * 删除用户
	 * @param Bookid
	 * @throws SQLException
	 */
	void delete(int Bookid) throws SQLException ;
	/**
	 * 更改用户数据
	 * @param Book
	 * @throws SQLException
	 */
	void update (Book Book) throws SQLException ;
	//根据id找书
	Book findBookById(int Bookid) throws SQLException; 
	//查询总记录数
	int findCount()throws SQLException ;
}
