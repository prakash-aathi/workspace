package com.examly.springappwifi.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springappwifi.model.WiFiSchemaRequest;
import com.examly.springappwifi.service.WiFiSchemaRequestService;

@RestController
@RequestMapping("/api/wifiSchemeRequest")
public class WiFiSchemaRequestController {

    private final WiFiSchemaRequestService wifiSchemaRequestService;

    public WiFiSchemaRequestController(WiFiSchemaRequestService wifiSchemaRequestService) {
        this.wifiSchemaRequestService = wifiSchemaRequestService;
    }

    @PreAuthorize("hasRole('User')")
    @PostMapping
    public ResponseEntity<WiFiSchemaRequest> createWiFiSchemaRequest(@RequestBody WiFiSchemaRequest wifiSchemaRequest) {
        WiFiSchemaRequest createdRequest = wifiSchemaRequestService.createWiFiSchemaRequest(wifiSchemaRequest);
        return ResponseEntity.created(URI.create("/api/wifiSchemeRequest/" + createdRequest.getWiFiSchemaRequestId()))
                .body(createdRequest);
    }

}
