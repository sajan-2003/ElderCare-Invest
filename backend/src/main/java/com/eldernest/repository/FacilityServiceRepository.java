package com.eldernest.repository;

import com.eldernest.entity.FacilityService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityServiceRepository
        extends JpaRepository<FacilityService, Long> {
}