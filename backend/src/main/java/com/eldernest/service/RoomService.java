package com.eldernest.service;

import com.eldernest.entity.Facility;
import com.eldernest.entity.Room;
import com.eldernest.repository.FacilityRepository;
import com.eldernest.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final FacilityRepository facilityRepository;

    public RoomService(
            RoomRepository roomRepository,
            FacilityRepository facilityRepository
    ) {
        this.roomRepository = roomRepository;
        this.facilityRepository = facilityRepository;
    }

    public Room addRoom(Long facilityId, Room room) {

        Optional<Facility> existingFacility =
                facilityRepository.findById(facilityId);

        if (existingFacility.isEmpty()) {
            return null;
        }

        room.setFacility(existingFacility.get());

        return roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    public List<Room> getAvailableRooms() {
        return roomRepository.findByAvailableTrue();
    }

    public List<Room> getRoomsByFacility(Long facilityId) {
        return roomRepository.findByFacilityId(facilityId);
    }

    public Room updateRoom(Long id, Room updatedRoom) {

        Optional<Room> existingRoom = roomRepository.findById(id);

        if (existingRoom.isEmpty()) {
            return null;
        }

        Room room = existingRoom.get();

        room.setRoomNumber(updatedRoom.getRoomNumber());
        room.setRoomType(updatedRoom.getRoomType());
        room.setCapacity(updatedRoom.getCapacity());
        room.setMonthlyPrice(updatedRoom.getMonthlyPrice());
        room.setAvailable(updatedRoom.isAvailable());

        return roomRepository.save(room);
    }

    public boolean deleteRoom(Long id) {

        if (!roomRepository.existsById(id)) {
            return false;
        }

        roomRepository.deleteById(id);
        return true;
    }
}