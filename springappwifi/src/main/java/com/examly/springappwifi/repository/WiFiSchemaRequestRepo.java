package com.examly.springappwifi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springappwifi.model.WiFiSchemaRequest;

public interface WiFiSchemaRequestRepo extends JpaRepository<WiFiSchemaRequest, Long> {
    
    List<WiFiSchemaRequest> findByUser_UserId(Long userId);
}
