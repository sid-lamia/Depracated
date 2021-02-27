package com.lamia.digitallibrary.dao;

import java.util.List;

import com.lamia.digitallibrary.model.Book;
import com.lamia.digitallibrary.model.Reservation;
import com.lamia.digitallibrary.model.User;

public interface IBookDao extends IStorage<Book>, IEditable<Book>, IRemovable<Book> {
	public List<Book> findByAuthor(String author);
	public List<Book> findByGenre(String genre);
	public List<Book> findByTitle(String title);
	public List<Book> findByKeyword(String title);
	public void reserve(Book book, User currentUser);
	public List<Reservation> findByUser(User user);
	public Reservation updateOverdueStatus(Reservation book);
	public List<Book> findAllReserved();
	public List<Book> findAllAvailable();
}
