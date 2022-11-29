<<<<<<< HEAD
package com.BookStore.App.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class orders {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private long orderid;
private long bookid;
private long userid;
private String status;
private Date dateofRent;
private Date dateofReturn;
@Override
public String toString() {
	return "orders [orderid=" + orderid + ", bookid=" + bookid + ", userid=" + userid + ", status=" + status
			+ ", dateofRent=" + dateofRent + ", dateofReturn=" + dateofReturn + "]";
}

public long getOrderid() {
	return orderid;
}
public void setOrderid(long orderid) {
	this.orderid = orderid;
}
public long getBookid() {
	return bookid;
}
public void setBookid(long bookid) {
	this.bookid = bookid;
}
public long getUserid() {
	return userid;
}
public void setUserid(long userid) {
	this.userid = userid;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Date getDateofRent() {
	return dateofRent;
}
public void setDateofRent(Date dateofRent) {
	this.dateofRent = dateofRent;
}
public Date getDateofReturn() {
	return dateofReturn;
}
public void setDateofReturn(Date dateofReturn) {
	this.dateofReturn = dateofReturn;
}

}
=======
package com.BookStore.App.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class orders {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private long orderid;
private long bookid;
private long userid;
private String status;
private Date dateofRent;
private Date dateofReturn;
@Override
public String toString() {
	return "orders [orderid=" + orderid + ", bookid=" + bookid + ", userid=" + userid + ", status=" + status
			+ ", dateofRent=" + dateofRent + ", dateofReturn=" + dateofReturn + "]";
}

public long getOrderid() {
	return orderid;
}
public void setOrderid(long orderid) {
	this.orderid = orderid;
}
public long getBookid() {
	return bookid;
}
public void setBookid(long bookid) {
	this.bookid = bookid;
}
public long getUserid() {
	return userid;
}
public void setUserid(long userid) {
	this.userid = userid;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Date getDateofRent() {
	return dateofRent;
}
public void setDateofRent(Date dateofRent) {
	this.dateofRent = dateofRent;
}
public Date getDateofReturn() {
	return dateofReturn;
}
public void setDateofReturn(Date dateofReturn) {
	this.dateofReturn = dateofReturn;
}

}
>>>>>>> ca582f80834f4d28f14e21c8df228f58a525cd47
