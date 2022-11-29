package com.BookStore.App.service;

import java.util.List;

import com.BookStore.App.model.book;

public interface BookService {
	book addbook(book book);
	book updatebook(book book);
	List<book> getbook();
	book getbookbyid(long id);
}
