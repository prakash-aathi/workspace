package com.examly.springappfeedback.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class Feedback {

    // feedbackId, feedbackText, date, User, wifiSchema, category 

    private String feedbackId;
    private String feedbackText;
    private LocalDate date;
    private User user;
    // private WifiSchema wifiSchema;
    private String category;
    
}
