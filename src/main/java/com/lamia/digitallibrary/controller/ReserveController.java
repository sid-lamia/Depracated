package com.lamia.digitallibrary.controller;

import com.lamia.digitallibrary.dao.IBookDao;
import com.lamia.digitallibrary.model.Book;
import com.lamia.digitallibrary.model.User;

public class ReserveController {

	private IBookDao bookDao; 
	
	public IBookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(IBookDao bookDao) {
		this.bookDao = bookDao;
	}


	public void reserveBook(Book book, User user){
		bookDao.reserve(book, user);
	}
	public ReserveController() {
		super();
	}

	
}
