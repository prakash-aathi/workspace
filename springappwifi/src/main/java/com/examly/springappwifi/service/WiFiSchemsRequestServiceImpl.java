package com.examly.springappwifi.service;

import org.springframework.stereotype.Service;

import com.examly.springappwifi.model.WiFiSchemaRequest;
import com.examly.springappwifi.repository.WiFiSchemaRequestRepo;

@Service
public class WiFiSchemsRequestServiceImpl implements WiFiSchemaRequestService {
    
    private final WiFiSchemaRequestRepo wifiSchemaRequestRepo;

    public WiFiSchemsRequestServiceImpl(WiFiSchemaRequestRepo wifiSchemaRequestRepo) {
        this.wifiSchemaRequestRepo = wifiSchemaRequestRepo;
    }

    @Override
    public WiFiSchemaRequest createWiFiSchemaRequest(WiFiSchemaRequest wifiSchemaRequest) {
        return wifiSchemaRequestRepo.save(wifiSchemaRequest);
    }
    
}
