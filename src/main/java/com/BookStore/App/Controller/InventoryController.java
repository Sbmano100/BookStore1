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

import com.BookStore.App.model.inventory;
import com.BookStore.App.service.InventoryService;

@RestController
public class InventoryController {

	 @Autowired
	 private InventoryService invservice;
	 
		//adding a new inventory
		 @PostMapping("/inventory")
		 private ResponseEntity<inventory> createinventory(@RequestBody inventory inventory){
			 return ResponseEntity.ok().body(this.invservice.addinventory(inventory));
		 }
	 
	 	//Getting inventory list
		 @GetMapping("/inventory")
		 private ResponseEntity<List<inventory>> getinventory(){
			 return ResponseEntity.ok().body(this.invservice.getinventory());
		 }
		 
		 //updating book
		 @PutMapping("/inventory/{id}")
		 private ResponseEntity<inventory> updatebook(@PathVariable long id, @RequestBody inventory inventory){
			 inventory.setBookid(id);
			 return ResponseEntity.ok().body(this.invservice.updateinventory(inventory));
		 }
		 
		 @GetMapping("/inventory/sortbylikes")
		 private ResponseEntity<List<String>> sortbylikes(){
			return ResponseEntity.ok().body(this.invservice.sortbylikes());
		}
		 
		 @GetMapping("/inventory/sortbydateadded")
	   	 private ResponseEntity<List<String>> sortbydate(){
				return ResponseEntity.ok().body(this.invservice.sortbydate());
		}
}
