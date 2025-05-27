package com.examly.springappwifi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springappwifi.model.WiFiSchema;

@Service
public interface WiFiSchemaService {

    WiFiSchema createWiFiSchema(WiFiSchema wifiSchema);

    WiFiSchema getWiFiSchemaById(long wifiSchemeId);

    List<WiFiSchema> getAllWiFiSchemas();



    
}
