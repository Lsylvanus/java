package com.book.model;

import java.util.Date;

public class Book {

	private int bookId;
	private String bookNO;
	private String bookName;
	private String author;
	private Date publishDate;
	private float price;
	private int bookTypeId=-1;
	private String bookTypeName;
	private String bookDesc;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String bookName, String author, Integer bookTypeId) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.bookTypeId = bookTypeId;
	}
	

	public Book(String bookNO, String bookName, String author, Date publishDate, float price, Integer bookTypeId,
			String bookDesc) {
		super();
		this.bookNO = bookNO;
		this.bookName = bookName;
		this.author = author;
		this.publishDate = publishDate;
		this.price = price;
		this.bookTypeId = bookTypeId;
		this.bookDesc = bookDesc;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookNO() {
		return bookNO;
	}

	public void setBookNO(String bookNO) {
		this.bookNO = bookNO;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	
	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Integer getBookTypeId() {
		return bookTypeId;
	}

	public void setBookTypeId(Integer bookTypeId) {
		this.bookTypeId = bookTypeId;
	}

	public String getBookTypeName() {
		return bookTypeName;
	}

	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}

	public String getBookDesc() {
		return bookDesc;
	}

	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}
}
