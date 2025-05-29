package com.examly.springappwifi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springappwifi.model.WiFiSchemaRequest;

@Service
public interface WiFiSchemaRequestService {

    WiFiSchemaRequest createWiFiSchemaRequest(WiFiSchemaRequest wifiSchemaRequest);

    WiFiSchemaRequest getWiFiSchemaRequestById(long wifiSchemeRequestId);

    List<WiFiSchemaRequest> getWiFiSchemasByUserId(long userId);

    List<WiFiSchemaRequest> getAllWiFiSchemaRequests();
    
}
