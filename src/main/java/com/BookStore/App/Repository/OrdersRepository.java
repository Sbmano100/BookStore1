package com.BookStore.App.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.BookStore.App.model.orders;

public interface OrdersRepository extends JpaRepository<orders, Long>{
	@Query(value = "Select * from bookstore.orders o where o.userid=?1", nativeQuery = true)
	List<orders> findnoofusers(long userid);
}
