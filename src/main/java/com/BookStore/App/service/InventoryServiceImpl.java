package com.BookStore.App.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BookStore.App.Repository.InventoryRepository;
import com.BookStore.App.exception.InventoryException;
import com.BookStore.App.model.inventory;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	private InventoryRepository inventoryrepo;
	
	@Override
	public inventory addinventory(inventory inventory) {
		return inventoryrepo.save(inventory);
	}
	
	@Override
	public List<inventory> getinventory(){
		return (List<inventory>) this.inventoryrepo.findAll();
	}
	
	@Override
	public inventory updateinventory(inventory inventory) {
	Optional<inventory> invobj=this.inventoryrepo.findById(inventory.getBookid());
	if(invobj.isPresent()) {
		inventory invupdate=invobj.get();
		invupdate.setBookname(inventory.getBookname());
		invupdate.setCategory(inventory.getCategory());
		invupdate.setAvailability(inventory.getAvailability());
		invupdate.setUnitprice(inventory.getUnitprice());
		invupdate.setLikes(inventory.getLikes());
		invupdate.setDateadded(inventory.getDateadded());
		return this.inventoryrepo.save(invupdate);
	}
	else {
		 throw new InventoryException("Inventory didn't found with id" +inventory.getBookid());
	}
	}
	
	//sort by likes
	@Override
	public List<String> sortbylikes(){
		List<String> likes=new ArrayList<>();
		List<inventory> inv=this.inventoryrepo.sortbylikes();
		for(inventory i:inv) {
			likes.add(i.toString());
		}
		return likes;
	}
	
	//sort by date added
	@Override
	public List<String> sortbydate(){
		List<String> date=new ArrayList<>();
		List<inventory> inv=this.inventoryrepo.sortbydate();
		for(inventory i:inv) {
			date.add(i.toString());
		}
		return date;
	}
	
	
	
	//rent the book
	public void rentbook(long id) {
		Optional<inventory> invobj=this.inventoryrepo.findById(id);
		inventory inv=invobj.get();
		int count=inv.getAvailability()-1;
		inv.setAvailability(count);
		inventoryrepo.save(inv);
		}
}
