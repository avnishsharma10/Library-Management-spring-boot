package com.libraryManagement.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	
	@Id
	@Column(name="bookid")
	private String bookid;
	
	
	@Column(name="quantity")
	private String quantity;
	
	@Column(name="bookName")
	private String bookName;
	
	@Column(name="genre")
	private String genre;

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Book(String bookid, String quantity, String bookName, String genre) {
		super();
		this.bookid = bookid;
		this.quantity = quantity;
		this.bookName = bookName;
		this.genre = genre;
	}
	public Book() {}
}