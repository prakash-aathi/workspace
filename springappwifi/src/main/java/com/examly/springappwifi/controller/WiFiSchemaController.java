package com.examly.springappwifi.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springappwifi.model.WiFiSchema;
import com.examly.springappwifi.service.WiFiSchemaService;

@RestController
@RequestMapping("/api/wifiSchema")
public class WiFiSchemaController {

    private final WiFiSchemaService wifiSchemaService;

    public WiFiSchemaController(WiFiSchemaService wifiSchemaService) {
        this.wifiSchemaService = wifiSchemaService;
    }

    @PreAuthorize("hasRole('Admin')")
    @PostMapping
    public ResponseEntity<WiFiSchema> createWiFiSchema(@RequestBody WiFiSchema wifiSchema) {
        WiFiSchema createdSchema = wifiSchemaService.createWiFiSchema(wifiSchema);
        return ResponseEntity.created(URI.create("/api/wifiSchema/" + createdSchema.getWifiSchemeId()))
                             .body(createdSchema);
    }
    
}
