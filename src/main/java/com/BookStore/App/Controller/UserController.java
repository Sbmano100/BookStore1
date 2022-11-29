package com.BookStore.App.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BookStore.App.model.user;
import com.BookStore.App.service.UserService;
@RestController
public class UserController {
	 @Autowired
	 private UserService userservice;
	 
		//creating a new user
		 @PostMapping("/user")
		 private ResponseEntity<user> saveuser(@RequestBody user user){
			 return ResponseEntity.ok().body(this.userservice.createuser(user));
		 }
	 
	 	//Getting all user info
		 @GetMapping("/user")
		 private ResponseEntity<List<user>> getalluser(){
			 return ResponseEntity.ok().body(this.userservice.getuser());
		 }
		 
		 //Getting user by id
		 @GetMapping("/user/{id}")
		 private user getuserbyid(@PathVariable long id) {
			 return this.userservice.getuserbyid(id);
		 }
		 
		 //updating user
		 @PutMapping("/user/{id}")
		 private ResponseEntity<user> updateuser(@PathVariable long id, @RequestBody user user){
			 user.setUserid(id);
			 return ResponseEntity.ok().body(this.userservice.updateuser(user));
		 }
		 
		 //Deleting user by id
		 @DeleteMapping("/user/{id}")
		 private HttpStatus deleteuser(@PathVariable long id) {
			 this.userservice.deleteuser(id);
			 return HttpStatus.OK;
		 }
		 
		 @PutMapping("/user/addmoney/{id}")
			private ResponseEntity<user> addmoney(@PathVariable long id,@RequestBody user user){
				user.setUserid(id);
				return ResponseEntity.ok().body(this.userservice.addmoney(user));
			}
			
}
