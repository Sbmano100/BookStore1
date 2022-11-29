package com.BookStore.App.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BookStore.App.model.book;
import com.BookStore.App.service.BookService;

@RestController
public class BookController {

	 @Autowired
	 private BookService bookservice;
	 
		//adding a new book
		 @PostMapping("/book")
		 private ResponseEntity<book> createbook(@RequestBody book book){
			 return ResponseEntity.ok().body(this.bookservice.addbook(book));
		 }
	 
	 	//Getting all book info
		 @GetMapping("/book")
		 private ResponseEntity<List<book>> getallbook(){
			 return ResponseEntity.ok().body(this.bookservice.getbook());
		 }
		 
		 //Getting book by id
		 @GetMapping("/book/{id}")
		 private book getbookbyid(@PathVariable long id) {
			 return this.bookservice.getbookbyid(id);
		 }
		 
		 //updating book
		 @PutMapping("/book/{id}")
		 private ResponseEntity<book> updatebook(@PathVariable long id, @RequestBody book book){
			 book.setBookid(id);
			 return ResponseEntity.ok().body(this.bookservice.updatebook(book));
		 }
		 
}
