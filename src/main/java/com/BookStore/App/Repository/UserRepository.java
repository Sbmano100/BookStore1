package com.BookStore.App.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BookStore.App.model.user;

public interface UserRepository extends JpaRepository<user, Long> {

}
