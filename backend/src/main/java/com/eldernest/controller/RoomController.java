package com.eldernest.controller;

import com.eldernest.entity.Room;
import com.eldernest.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    // Create a room under a specific facility
    @PostMapping("/facility/{facilityId}")
    public ResponseEntity<Room> addRoom(
            @PathVariable Long facilityId,
            @RequestBody Room room
    ) {
        Room savedRoom = roomService.addRoom(facilityId, room);

        if (savedRoom == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedRoom);
    }

    // Get all rooms
    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        return ResponseEntity.ok(roomService.getAllRooms());
    }

    // Get one room by ID
    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(
            @PathVariable Long id
    ) {
        return roomService.getRoomById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get all available rooms
    @GetMapping("/available")
    public ResponseEntity<List<Room>> getAvailableRooms() {
        return ResponseEntity.ok(
                roomService.getAvailableRooms()
        );
    }

    // Get rooms belonging to a facility
    @GetMapping("/facility/{facilityId}")
    public ResponseEntity<List<Room>> getRoomsByFacility(
            @PathVariable Long facilityId
    ) {
        return ResponseEntity.ok(
                roomService.getRoomsByFacility(facilityId)
        );
    }

    // Update a room
    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(
            @PathVariable Long id,
            @RequestBody Room room
    ) {
        Room updatedRoom = roomService.updateRoom(id, room);

        if (updatedRoom == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedRoom);
    }

    // Delete a room
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(
            @PathVariable Long id
    ) {
        boolean deleted = roomService.deleteRoom(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}