package com.BookStore.App.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inventory")
public class inventory {
	@Id
	private long bookid;
	private String bookname;
	private String category;
	private int availability;
	private int unitprice;
	private int likes;
	private Date dateadded;
	
	@Override
	public String toString() {
		return "inventory [bookid=" + bookid + ", bookname=" + bookname + ", category=" + category + ", availability="
				+ availability + ", unitprice=" + unitprice + ", likes=" + likes + ", dateadded=" + dateadded + "]";
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
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public int getAvailability() {
	return availability;
}
public void setAvailability(int availability) {
	this.availability = availability;
}
public int getUnitprice() {
	return unitprice;
}
public void setUnitprice(int unitprice) {
	this.unitprice = unitprice;
}
public int getLikes() {
	return likes;
}
public void setLikes(int likes) {
	this.likes = likes;
}
public Date getDateadded() {
	return dateadded;
}
public void setDateadded(Date dateadded) {
	this.dateadded = dateadded;
}


}
