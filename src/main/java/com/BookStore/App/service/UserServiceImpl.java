package com.BookStore.App.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BookStore.App.Repository.UserRepository;
import com.BookStore.App.exception.UserException;
import com.BookStore.App.model.user;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userrepo;
	
	@Override
	public user createuser(user user) {
		return userrepo.save(user);
	}
	
	@Override
	public List<user> getuser(){
		return (List<user>) this.userrepo.findAll();
	}
	
	@Override
	public user getuserbyid(long id) {
		Optional<user> userobj=this.userrepo.findById(id);
		if(userobj.isPresent()) {
			return userobj.get();
			}
		else {
			throw new UserException("user didn't found with id:" +id); 
		}
	}

	@Override
	public user updateuser(user user) {
	Optional<user> userobj=this.userrepo.findById(user.getUserid());
	if(userobj.isPresent()) {
		user userupdate=userobj.get();
		userupdate.setUserid(user.getUserid());
		userupdate.setUsername(user.getUsername());
		userupdate.setMailid(user.getMailid());
		userupdate.setContactno(user.getContactno());
		userupdate.setBalance(user.getBalance());
		return this.userrepo.save(userupdate);
	}
	else {
		 throw new UserException("user didn't found with id" +user.getUserid());
	}
	}
	
	@Override
	public void deleteuser(long id) {
		Optional<user> userobj=this.userrepo.findById(id);
		if(userobj.isPresent()) {
			this.userrepo.deleteById(id);
		}
		else {
			throw new UserException("user didn't found with id" +id);
		}
	}
	
	@Override
	public user addmoney(user user) {
		Optional<user> userobj=this.userrepo.findById(user.getUserid());
		user userupdate=userobj.get();
		if(user.getBalance()%500==0) {
			userupdate.setBalance(user.getBalance()+userupdate.getBalance());
			return this.userrepo.save(userupdate);
		}
		else {
			 return userupdate;
		}
	}
	
	@Override
	public user deductmoney(long id,double price) {
		Optional<user> userobj=this.userrepo.findById(id);
		if(userobj.isPresent()) {
			user userupdate=userobj.get();
			userupdate.setBalance(userupdate.getBalance()-price);
			return this.userrepo.save(userupdate);
		}
		else {
			throw new UserException("user didn't find with id "+id);
		}
	}
	
}
