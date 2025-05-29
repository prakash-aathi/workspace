package com.examly.springappfeedback.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WiFiSchema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long wifiSchemeId;
    private String schemeName;

    public WiFiSchema() {
        // no-arg constructor
    }

    public long getWifiSchemeId() {
        return wifiSchemeId;
    }

    public void setWifiSchemeId(long wifiSchemeId) {
        this.wifiSchemeId = wifiSchemeId;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    
}
