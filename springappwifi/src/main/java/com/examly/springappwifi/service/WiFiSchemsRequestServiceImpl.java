package com.examly.springappwifi.service;

import java.util.List;
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

        if (wifiSchemaRequest.getWifiScheme() == null || wifiSchemaRequest.getWifiScheme().getWifiSchemeId() == 0) {
            throw new IllegalArgumentException("WiFi Scheme ID is required in the request");
        }

        // get user by ID or else create a new user
        Optional<User> user = userRepo.findById(wifiSchemaRequest.getUser().getUserId());
        if (user.isPresent()) {
            wifiSchemaRequest.setUser(user.get());
        } else {
            wifiSchemaRequest.setUser(userRepo.save(wifiSchemaRequest.getUser()));
        }

        // get WiFi schema by ID
        WiFiSchema wiFiSchema = wifiSchemaService
                .getWiFiSchemaById(wifiSchemaRequest.getWifiScheme().getWifiSchemeId());
        if (wiFiSchema != null) {
            wifiSchemaRequest.setWifiScheme(wiFiSchema);
        } else {
            throw new IllegalArgumentException(
                    "WiFi Schema not found for ID: " + wifiSchemaRequest.getWifiScheme().getWifiSchemeId());
        }
        return wifiSchemaRequestRepo.save(wifiSchemaRequest);
    }

    @Override
    public WiFiSchemaRequest getWiFiSchemaRequestById(long wifiSchemeRequestId) {
        return wifiSchemaRequestRepo.findById(wifiSchemeRequestId)
                .orElseThrow(() -> new RuntimeException("WiFi Schema Request not found with id: " + wifiSchemeRequestId));
    }

    @Override
    public List<WiFiSchemaRequest> getWiFiSchemasByUserId(long userId) {
       
       return  wifiSchemaRequestRepo.findByUser_UserId(userId);
        
    }

    @Override
    public List<WiFiSchemaRequest> getAllWiFiSchemaRequests() {
        return wifiSchemaRequestRepo.findAll();
    }

}
