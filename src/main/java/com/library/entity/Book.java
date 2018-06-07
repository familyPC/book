 package com.library.entity;

public class Book {

	private long bookId;
	private String name;
	private int amount;
	private String introd;
	
	
	public Book() {
		
	}
	public Book(long bookId, String name, int amount) {
		
		this.bookId = bookId;
		this.name = name;
		this.amount = amount;
	}
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getIntrod() {
		return introd;
	}
	public void setIntrod(String introd) {
		this.introd = introd;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", amount=" + amount + ", introd=" + introd + "]";
	}
	
	
}
