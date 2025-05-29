package com.examly.springappfeedback.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Feedback {

    // feedbackId, feedbackText, date, User, wifiSchema, category

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long feedbackId;
    private String feedbackText;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "wifiSchemeId", nullable = false)
    @JsonProperty("wifiScheme")
    private WiFiSchema wifiSchema;
    private String category;

    public Feedback() {
        // no-arg constructor
    }

    public long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public WiFiSchema getWifiSchema() {
        return wifiSchema;
    }

    public void setWifiSchema(WiFiSchema wifiSchema) {
        this.wifiSchema = wifiSchema;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    

}
