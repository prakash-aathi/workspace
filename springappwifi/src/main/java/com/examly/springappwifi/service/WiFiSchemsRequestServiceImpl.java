package com.examly.springappwifi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.examly.springappwifi.model.User;
import com.examly.springappwifi.model.WiFiSchema;
import com.examly.springappwifi.model.WiFiSchemaRequest;
import com.examly.springappwifi.repository.UserRepo;
import com.examly.springappwifi.repository.WiFiSchemaRequestRepo;

@Service
public class WiFiSchemsRequestServiceImpl implements WiFiSchemaRequestService {
    
    private final WiFiSchemaRequestRepo wifiSchemaRequestRepo;
    private final UserRepo userRepo;
    private final WiFiSchemaService wifiSchemaService;

    public WiFiSchemsRequestServiceImpl(WiFiSchemaRequestRepo wifiSchemaRequestRepo, 
                                        UserRepo userRepo, 
                                        WiFiSchemaService wifiSchemaService) {
        this.wifiSchemaRequestRepo = wifiSchemaRequestRepo;
        this.userRepo = userRepo;
        this.wifiSchemaService = wifiSchemaService;
    }

    @Override
    public WiFiSchemaRequest createWiFiSchemaRequest(WiFiSchemaRequest wifiSchemaRequest) {
        // get user by ID or else create a new user
        Optional<User> user = userRepo.findById(wifiSchemaRequest.getUser().getUserId());
        if (user.isPresent()) {
            wifiSchemaRequest.setUser(user.get());
        } else {
            wifiSchemaRequest.setUser(userRepo.save(wifiSchemaRequest.getUser()));
        }

        //  get WiFi schema by ID
        WiFiSchema wiFiSchema = wifiSchemaService.getWiFiSchemaById(wifiSchemaRequest.getWiFiScheme().getWifiSchemeId());
        if (wiFiSchema != null) {
            wifiSchemaRequest.setWiFiScheme(wiFiSchema);
        } else {
            throw new IllegalArgumentException("WiFi Schema not found for ID: " + wifiSchemaRequest.getWiFiScheme().getWifiSchemeId());
        }
        return wifiSchemaRequestRepo.save(wifiSchemaRequest);
    }
    
}
