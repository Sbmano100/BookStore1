package com.BookStore.App.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BookStore.App.Repository.BookRepository;
import com.BookStore.App.Repository.UserRepository;
import com.BookStore.App.exception.BookException;
import com.BookStore.App.model.book;
import com.BookStore.App.model.user;

@Service
@Transactional
public class BookServiceImpl implements BookService{
	@Autowired
	private BookRepository bookrepo;
	
	@Override
	public book addbook(book book) {
		return bookrepo.save(book);
	}
	
	@Override
	public List<book> getbook(){
		return (List<book>) this.bookrepo.findAll();
	}
	
	@Override
	public book getbookbyid(long id) {
		Optional<book> bookobj=this.bookrepo.findById(id);
		if(bookobj.isPresent()) {
			return bookobj.get();
			}
		else {
			throw new BookException("Book didn't found with id:" +id); 
		}
	}
	
	@Override
	public book updatebook(book book) {
	Optional<book> bookobj=this.bookrepo.findById(book.getBookid());
	if(bookobj.isPresent()) {
		book bookupdate=bookobj.get();
		bookupdate.setBookid(book.getBookid());
		bookupdate.setBookname(book.getBookname());
		bookupdate.setAuthor(book.getAuthor());
		bookupdate.setPrice(book.getPrice());
		bookupdate.setCategory(book.getCategory());
		return this.bookrepo.save(bookupdate);
	}
	else {
		 throw new BookException("Book didn't found with id" +book.getBookid());
	}
	}
	
}
