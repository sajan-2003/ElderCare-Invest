package com.eldernest.repository;

import com.eldernest.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByFacilityId(Long facilityId);
    List<Room> findByAvailableTrue();
}