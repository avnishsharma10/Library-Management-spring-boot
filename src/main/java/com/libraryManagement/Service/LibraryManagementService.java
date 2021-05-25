package com.libraryManagement.Service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.libraryManagement.Entity.Book;
import com.libraryManagement.Exception.LibraryManagementException;

public interface LibraryManagementService {
	public List<Book> getAllBook() throws LibraryManagementException;
	public List<Book> getBookByGenre(String genre) throws LibraryManagementException;

	public String addBook(Book book) throws LibraryManagementException;
	public Book updateBookById(Book book, String id) throws LibraryManagementException;
	public String deleteBookById(String id) throws LibraryManagementException;

	
}
