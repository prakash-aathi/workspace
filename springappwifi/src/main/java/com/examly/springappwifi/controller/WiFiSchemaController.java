package com.examly.springappwifi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springappwifi.model.WiFiSchema;
import com.examly.springappwifi.service.WiFiSchemaService;

@RestController
@RequestMapping("/api/wifiScheme")
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
    
    @PreAuthorize("hasRole('Admin')")
    @GetMapping("/{wifiSchemeId}")
    public ResponseEntity<WiFiSchema> getWiFiSchema(@PathVariable long wifiSchemeId) {
        WiFiSchema wifiSchema = wifiSchemaService.getWiFiSchemaById(wifiSchemeId);
        return ResponseEntity.ok(wifiSchema);
    }

    @GetMapping
    public ResponseEntity<List<WiFiSchema>> getAllWiFiSchemas() {
        List<WiFiSchema> wifiSchemas = wifiSchemaService.getAllWiFiSchemas();
        return ResponseEntity.ok(wifiSchemas);
    }

    @PreAuthorize("hasRole('Admin')")
    @PutMapping("/{wifiSchemeId}")
    public ResponseEntity<WiFiSchema> updateWiFiSchema(@PathVariable long wifiSchemeId,
            @RequestBody WiFiSchema wifiSchema) {
        WiFiSchema existingSchema = wifiSchemaService.getWiFiSchemaById(wifiSchemeId);
        existingSchema.setSchemeName(wifiSchema.getSchemeName());
        existingSchema.setDescription(wifiSchema.getDescription());
        existingSchema.setSpeed(wifiSchema.getSpeed());
        existingSchema.setDataLimit(wifiSchema.getDataLimit());
        existingSchema.setFee(wifiSchema.getFee());
        existingSchema.setAvailabilityStatus(wifiSchema.getAvailabilityStatus());

        WiFiSchema updatedSchema = wifiSchemaService.createWiFiSchema(existingSchema);
        return ResponseEntity.ok(updatedSchema);
    }

    
}
