package com.eldernest.controller;

import com.eldernest.dto.FacilityServiceRequest;
import com.eldernest.entity.FacilityService;
import com.eldernest.service.FacilityServiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/services")
public class FacilityServiceController {

    private final FacilityServiceService facilityServiceService;

    public FacilityServiceController(
            FacilityServiceService facilityServiceService
    ) {
        this.facilityServiceService = facilityServiceService;
    }

    @GetMapping
    public ResponseEntity<List<FacilityService>> getAllServices() {

        return ResponseEntity.ok(
                facilityServiceService.getAllServices()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacilityService> getServiceById(
            @PathVariable Long id
    ) {

        return facilityServiceService
                .getServiceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FacilityService> addService(
            @RequestBody FacilityServiceRequest request
    ) {

        FacilityService savedService =
                facilityServiceService.addService(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedService);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacilityService> updateService(
            @PathVariable Long id,
            @RequestBody FacilityServiceRequest request
    ) {

        FacilityService updatedService =
                facilityServiceService.updateService(id, request);

        return ResponseEntity.ok(updatedService);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(
            @PathVariable Long id
    ) {

        boolean deleted =
                facilityServiceService.deleteService(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}