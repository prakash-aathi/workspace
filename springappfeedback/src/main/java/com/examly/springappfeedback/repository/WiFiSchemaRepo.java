package com.examly.springappfeedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springappfeedback.model.WiFiSchema;

public interface WiFiSchemaRepo extends JpaRepository<WiFiSchema, Long> {
    
    
}
