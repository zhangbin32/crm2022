package com.mage.bean;

public class OperaBook {
	private int operatid;//借阅ID
	private int bookid;//图书ID
	private String bookname;//图书名称
	private int userid;//用户ID
	private String username;//用户名
	private String borrowtime;//借阅时间
	private int renttime;//归还期限 
	private boolean isreturn;//是否归还
	
	public OperaBook() {
		super();
	}
	public OperaBook(int operatid, int bookid, String bookname, int userid, String username, String borrowtime,
			int renttime, boolean isreturn) {
		super();
		this.operatid = operatid;
		this.bookid = bookid;
		this.bookname = bookname;
		this.userid = userid;
		this.username = username;
		this.borrowtime = borrowtime;
		this.renttime = renttime;
		this.isreturn = isreturn;
	}
	public int getOperatid() {
		return operatid;
	}
	public void setOperatid(int operatid) {
		this.operatid = operatid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getRenttime() {
		return renttime;
	}
	public void setRenttime(int renttime) {
		this.renttime = renttime;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getBorrowtime() {
		return borrowtime;
	}
	public void setBorrowtime(String borrowtime) {
		this.borrowtime = borrowtime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isIsreturn() {
		return isreturn;
	}
	public void setIsreturn(boolean isreturn) {
		this.isreturn = isreturn;
	}
	
	
}
