package com.BookStore.App.service;

import java.util.List;

import com.BookStore.App.model.inventory;

public interface InventoryService {

	inventory addinventory(inventory inventory);
	List<inventory> getinventory();
	inventory updateinventory(inventory inventory);
	List<String> sortbylikes();
	List<String> sortbydate();
	void rentbook(long id);
	
}
