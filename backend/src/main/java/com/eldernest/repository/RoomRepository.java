package com.eldernest.repository;

import com.eldernest.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByFacilityId(Long facilityId);
    List<Room> findByAvailableTrue();

}