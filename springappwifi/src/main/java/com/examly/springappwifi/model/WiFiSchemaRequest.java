package com.examly.springappwifi.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class WiFiSchemaRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long wiFiSchemaRequestId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "wifiSchemeId", nullable = false)
    @JsonProperty("wifiScheme")
    private WiFiSchema wifiScheme;
    private LocalDate requestDate;
    private String status;
    private String comments;

    // lob base 64 encoded string
    @Lob
    private String proof;
    private String streetName;
    private String landmark;
    private String city;
    private String state;
    private String zipCode;
    private LocalDate prefferedSetupDate;
    private String prefferedSetupTime;
    private String timeSlot;

    public WiFiSchemaRequest() {
        // Default constructor
    }

    public long getWiFiSchemaRequestId() {
        return wiFiSchemaRequestId;
    }

    public void setWiFiSchemaRequestId(long wiFiSchemaRequestId) {
        this.wiFiSchemaRequestId = wiFiSchemaRequestId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public WiFiSchema getWifiScheme() {
        return wifiScheme;
    }

    public void setWifiScheme(WiFiSchema wifiScheme) {
        this.wifiScheme = wifiScheme;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getProof() {
        return proof;
    }

    public void setProof(String proof) {
        this.proof = proof;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public LocalDate getPrefferedSetupDate() {
        return prefferedSetupDate;
    }

    public void setPrefferedSetupDate(LocalDate prefferedSetupDate) {
        this.prefferedSetupDate = prefferedSetupDate;
    }

    public String getPrefferedSetupTime() {
        return prefferedSetupTime;
    }

    public void setPrefferedSetupTime(String prefferedSetupTime) {
        this.prefferedSetupTime = prefferedSetupTime;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

}
