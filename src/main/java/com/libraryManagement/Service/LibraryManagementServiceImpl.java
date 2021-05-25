package com.libraryManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryManagement.Dao.LibraryManagementDao;
import com.libraryManagement.Entity.Book;
import com.libraryManagement.Exception.LibraryManagementException;

@Service
public class LibraryManagementServiceImpl implements LibraryManagementService{

	
	@Autowired
	LibraryManagementDao libraryManagementDao;
	@Override
	public List<Book> getAllBook() throws LibraryManagementException {
		// TODO Auto-generated method stub
		return libraryManagementDao.getAllBook();
	}
	@Override
	public List<Book> getBookByGenre(String genre) throws LibraryManagementException {
		// TODO Auto-generated method stub
		return libraryManagementDao.getBookByGenre(genre);	}
	@Override
	public String addBook(Book book) throws LibraryManagementException {
		// TODO Auto-generated method stub
		return libraryManagementDao.addBook(book);	}
	@Override
	public Book updateBookById(Book book, String id) throws LibraryManagementException {
		// TODO Auto-generated method stub
		return libraryManagementDao.updateBookById(book, id);
	}
	@Override
	public String deleteBookById(String id) throws LibraryManagementException {
		// TODO Auto-generated method stub
		return libraryManagementDao.deleteBookById(id);
	}

	
}
