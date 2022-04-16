package com.mage.dao;

import java.sql.SQLException;
import java.util.List;

import com.mage.bean.PageBean;
import com.mage.bean.User;



public interface UserDao {
	
	int PAGE_SIZE = 5; //分页显示多少条记录
	/**
	 * 查询当页的用户数�?
	 * @param currentPage
	 * @return
	 * @throws SQLException
	 */
	List<User> findUserByPage(int currentPage) throws SQLException;
	List<User> findAll()  throws SQLException ;
	/**
	 * 添加用户
	 * @param User 要添加到数据库的用户对象
	 * @throws SQLException
	 */
	void insert(User user) throws SQLException ;
	/**
	 *  模糊查询
	 * @param username
	 * @param usertype
	 * @return
	 * @throws SQLException
	 */
	User searchUserForLogin(String username,String password,String usertype) throws SQLException ;
	List<User> searchUser(String username,String usertype) throws SQLException ;
	/**
	 * 删除用户
	 * @param userid
	 * @throws SQLException
	 */
	void delete(int userid) throws SQLException ;
	/**
	 * 更改用户数据
	 * @param user
	 * @throws SQLException
	 */
	void update (User user) throws SQLException ;
	//根据id找用
	User findUserById(int userid) throws SQLException; 
	//查询总记录数
	int findCount()throws SQLException ;
	//分页查询用户信息
	public PageBean findUserByPages(int currentPage) throws SQLException;
}
