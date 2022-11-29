package com.BookStore.App.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userdetails")
public class user {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userid;
	private String username;
	private String mailid;
	private long contactno;
	private double balance;
	
	
	
	@Override
	public String toString() {
		return "details [userid=" + userid + ", username=" + username + ", mailid=" + mailid + ", contactno="
				+ contactno + ", balance=" + balance + "]";
	}
	
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public long getContactno() {
		return contactno;
	}
	public void setContactno(long contactno) {
		this.contactno = contactno;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

}
