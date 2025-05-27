package com.examly.springappwifi.service;

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

}
