package com.BookStore.App.service;

import java.util.List;

import com.BookStore.App.model.user;

public interface UserService{
	user createuser(user user);
	user updateuser(user user);
	List<user> getuser();
	user getuserbyid(long id);
	void deleteuser(long id);
	user addmoney(user user);
	user deductmoney(long id,double price);
}
