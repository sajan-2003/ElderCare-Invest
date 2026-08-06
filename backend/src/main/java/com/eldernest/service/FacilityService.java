package com.eldernest.service;
import com.eldernest.entity.Facility;
import com.eldernest.repository.FacilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityService {

    private final FacilityRepository facilityRepository;

    public FacilityService(FacilityRepository facilityRepository) {
        this.facilityRepository = facilityRepository;
    }

    public Facility addFacility(Facility facility){
        return facilityRepository.save(facility);
    }

    public List<Facility> getAllFacilities(){
        return facilityRepository.findAll();
    }

    public Facility updateFacility(Long id, Facility updatedFacility){
        Optional<Facility> existingFacility = facilityRepository.findById(id);

        if (existingFacility.isPresent()){
            Facility facility =existingFacility.get();

            facility.setName(updatedFacility.getName());
            facility.setLocation(updatedFacility.getLocation());
            facility.setDescription(updatedFacility.getDescription());
            facility.setContactNumber(updatedFacility.getContactNumber());
            facility.setEmail(updatedFacility.getEmail());
            facility.setCapacity(updatedFacility.getCapacity());
            facility.setActive(updatedFacility.isActive());

            return facilityRepository.save(facility);

        }
        return null;
    }
    public boolean deleteFacility(Long id) {

        if (facilityRepository.existsById(id)) {
            facilityRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public Optional<Facility> getFacilityById(Long id) {
        return facilityRepository.findById(id);
    }

}

