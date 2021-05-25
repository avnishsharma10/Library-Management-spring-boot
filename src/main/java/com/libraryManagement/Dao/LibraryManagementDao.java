package com.libraryManagement.Dao;

import java.util.List;

import com.libraryManagement.Entity.Book;
import com.libraryManagement.Exception.LibraryManagementException;

public interface LibraryManagementDao {
	public List<Book> getAllBook() throws LibraryManagementException;
	public List<Book> getBookByGenre(String genre) throws LibraryManagementException;

	public String addBook(Book book) throws LibraryManagementException;
	public Book updateBookById(Book book, String id) throws LibraryManagementException;
	public String deleteBookById(String id) throws LibraryManagementException;

}
