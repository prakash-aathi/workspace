package com.examly.springappwifi.service;

import org.springframework.stereotype.Service;

import com.examly.springappwifi.model.WiFiSchemaRequest;

@Service
public interface WiFiSchemaRequestService {

    WiFiSchemaRequest createWiFiSchemaRequest(WiFiSchemaRequest wifiSchemaRequest);
    
}
