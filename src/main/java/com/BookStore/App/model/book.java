package com.BookStore.App.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private long bookid;
private String bookname;
private String author;
private int price;
private String category;

@Override
public String toString() {
	return "book [bookid=" + bookid + ", bookname=" + bookname + ", author=" + author + ", price=" + price
			+ ", category=" + category + "]";
}

public long getBookid() {
	return bookid;
}
public void setBookid(long bookid) {
	this.bookid = bookid;
}
public String getBookname() {
	return bookname;
}
public void setBookname(String bookname) {
	this.bookname = bookname;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}

}
