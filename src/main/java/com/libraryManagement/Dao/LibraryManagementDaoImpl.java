package com.libraryManagement.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import com.libraryManagement.Entity.Book;
import com.libraryManagement.Exception.LibraryManagementException;
import com.libraryManagement.Service.LibraryManagementService;

import ch.qos.logback.classic.Logger;



@Repository
@Transactional
public class LibraryManagementDaoImpl implements LibraryManagementDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Book> getAllBook() throws LibraryManagementException {
		TypedQuery<Book> query = entityManager.createQuery("FROM Book", Book.class);
		List<Book> bookList = query.getResultList();
		return bookList;
	}

	@Override
	public List<Book> getBookByGenre(String genre) throws LibraryManagementException {
		List<Book> book;
		try{
		TypedQuery<Book> query = entityManager.createQuery("FROM Book where genre = :genre", Book.class);
		
		query.setParameter("genre", genre);
		 book = query.getResultList();
		 	if(book.size()==0)
		 	{
		 		throw new LibraryManagementException("No records found!!!");
		 	}
		}
		catch (Exception e) {
			throw new LibraryManagementException("No records found!!!");
		}
		
		
		return book;
		}


	@Override
	public String addBook(Book book) throws LibraryManagementException {
		entityManager.persist(book);
		//		entityManager.close();
		return book.getBookid();
	}

	@Override
	public Book updateBookById(Book book, String Bookid) throws LibraryManagementException {
		Book book1 = entityManager.find(Book.class, Bookid);
		book1.setBookName(book.getBookName());
		book1.setGenre(book.getGenre());
		book1.setQuantity(book.getQuantity());

		entityManager.merge(book1);
		
		return book1;
	}

	@Override
	public String deleteBookById(String Bookid) throws LibraryManagementException {
		String Message = "";
		Book book = entityManager.find(Book.class, Bookid);
		if (book != null) {
			entityManager.remove(book);
			Message = "DELETED SUCCESSFULLY";
		} else {
			throw new LibraryManagementException("No Book Found");
		}
		return Message;

	}

}
