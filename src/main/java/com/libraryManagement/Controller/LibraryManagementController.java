package com.libraryManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.libraryManagement.Entity.Book;
import com.libraryManagement.Exception.LibraryManagementException;
import com.libraryManagement.Service.LibraryManagementService;


@CrossOrigin("*")
@RestController
public class LibraryManagementController {
	
		
		@Autowired
		LibraryManagementService libraryManagementService;
		
		@GetMapping(value = "/getAllBook")
		public List<Book> getAllBook() throws LibraryManagementException {
			return libraryManagementService.getAllBook();
		}
		
		@GetMapping(value = "/getByType")
		public List<Book> getByType(@RequestParam String id) throws LibraryManagementException {
			return libraryManagementService.getBookByGenre(id);
		}
		
		@GetMapping(value = "/deleteBook")
		public String get(@RequestParam String bookid) throws LibraryManagementException {
		    return libraryManagementService.deleteBookById(bookid);
		}

		@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
		public String addBook(@RequestBody Book book) throws LibraryManagementException {
			String bookId = libraryManagementService.addBook(book);
			return "Book Successfully Added,BookId is " + bookId;
		}
		
		@PostMapping("/editBook")
		public Book editBook(@RequestBody Book book,@RequestParam String bookid) throws LibraryManagementException {
		    return libraryManagementService.updateBookById(book, bookid);
		}


	}
