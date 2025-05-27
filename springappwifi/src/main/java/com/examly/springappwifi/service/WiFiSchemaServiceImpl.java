package com.examly.springappwifi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springappwifi.model.WiFiSchema;
import com.examly.springappwifi.repository.WiFiSchemaRepo;

@Service
public class WiFiSchemaServiceImpl implements WiFiSchemaService {

    private final WiFiSchemaRepo wifiSchemaRepo;

    public WiFiSchemaServiceImpl(WiFiSchemaRepo wifiSchemaRepo) {
        this.wifiSchemaRepo = wifiSchemaRepo;
    }

    @Override
    public WiFiSchema createWiFiSchema(WiFiSchema wifiSchema) {
        return wifiSchemaRepo.save(wifiSchema);
    }

    @Override
    public WiFiSchema getWiFiSchemaById(long wifiSchemeId) {
        return wifiSchemaRepo.findById(wifiSchemeId)
                .orElseThrow(() -> new RuntimeException("WiFi Schema not found with id: " + wifiSchemeId));
    }

    @Override
    public List<WiFiSchema> getAllWiFiSchemas() {
        return wifiSchemaRepo.findAll();
    }

}
