package com.BookStore.App.Repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.BookStore.App.model.inventory;

public interface InventoryRepository extends JpaRepository<inventory, Long>{
	

	@Query(value="Select * from inventory i order by likes desc",nativeQuery = true)
	List<inventory> sortbylikes();
	@Query(value="Select * from inventory i order by dateadded desc",nativeQuery = true)
	List<inventory> sortbydate();

}
