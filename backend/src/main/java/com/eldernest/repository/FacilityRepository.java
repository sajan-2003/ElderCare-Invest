package com.eldernest.repository;

import com.eldernest.entity.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityRepository
        extends JpaRepository<Facility, Long> {
}