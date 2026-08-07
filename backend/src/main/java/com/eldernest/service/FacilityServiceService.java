package com.eldernest.service;

import com.eldernest.dto.FacilityServiceRequest;
import com.eldernest.entity.Facility;
import com.eldernest.entity.FacilityService;
import com.eldernest.repository.FacilityRepository;
import com.eldernest.repository.FacilityServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityServiceService {

    private final FacilityServiceRepository facilityServiceRepository;
    private final FacilityRepository facilityRepository;

    public FacilityServiceService(
            FacilityServiceRepository facilityServiceRepository,
            FacilityRepository facilityRepository
    ) {
        this.facilityServiceRepository = facilityServiceRepository;
        this.facilityRepository = facilityRepository;
    }

    public List<FacilityService> getAllServices() {
        return facilityServiceRepository.findAll();
    }

    public Optional<FacilityService> getServiceById(Long id) {
        return facilityServiceRepository.findById(id);
    }

    public FacilityService addService(FacilityServiceRequest request) {

        Facility facility = facilityRepository
                .findById(request.getFacilityId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Facility not found with id: "
                                        + request.getFacilityId()
                        )
                );

        FacilityService service = new FacilityService();

        service.setFacility(facility);
        service.setServiceName(request.getServiceName());
        service.setDescription(request.getDescription());
        service.setCost(request.getCost());
        service.setCategory(request.getCategory());
        service.setServiceStatus(request.getServiceStatus());

        return facilityServiceRepository.save(service);
    }

    public FacilityService updateService(
            Long id,
            FacilityServiceRequest request
    ) {

        FacilityService existingService =
                facilityServiceRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Service not found with id: " + id
                                )
                        );

        Facility facility = facilityRepository
                .findById(request.getFacilityId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Facility not found with id: "
                                        + request.getFacilityId()
                        )
                );

        existingService.setFacility(facility);
        existingService.setServiceName(request.getServiceName());
        existingService.setDescription(request.getDescription());
        existingService.setCost(request.getCost());
        existingService.setCategory(request.getCategory());
        existingService.setServiceStatus(request.getServiceStatus());

        return facilityServiceRepository.save(existingService);
    }

    public boolean deleteService(Long id) {

        if (!facilityServiceRepository.existsById(id)) {
            return false;
        }

        facilityServiceRepository.deleteById(id);

        return true;
    }
}