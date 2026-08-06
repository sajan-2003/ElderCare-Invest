package com.eldernest.controller;

import com.eldernest.entity.Facility;
import com.eldernest.service.FacilityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/facilities")
public class FacilityController {

    private final FacilityService facilityService;

    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    // Create
    @PostMapping
    public ResponseEntity<Facility> addFacility(
            @RequestBody Facility facility
    ) {
        Facility savedFacility = facilityService.addFacility(facility);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedFacility);
    }

    // Read all
    @GetMapping
    public ResponseEntity<List<Facility>> getAllFacilities() {
        return ResponseEntity.ok(
                facilityService.getAllFacilities()
        );
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<Facility> getFacilityById(
            @PathVariable Long id
    ) {
        return facilityService.getFacilityById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Facility> updateFacility(
            @PathVariable Long id,
            @RequestBody Facility facility
    ) {
        Facility updatedFacility =
                facilityService.updateFacility(id, facility);

        if (updatedFacility == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedFacility);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFacility(
            @PathVariable Long id
    ) {
        boolean deleted = facilityService.deleteFacility(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}