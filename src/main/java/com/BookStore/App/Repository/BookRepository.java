package com.BookStore.App.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BookStore.App.model.book;

public interface BookRepository extends JpaRepository<book,Long> {

}
