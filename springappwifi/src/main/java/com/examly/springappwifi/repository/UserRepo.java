package com.examly.springappwifi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springappwifi.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

    
}
