package com.eldernest.controller;

import com.eldernest.entity.Booking;
import com.eldernest.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // Create booking
    @PostMapping("/user/{userId}/room/{roomId}")
    public ResponseEntity<Booking> addBooking(
            @PathVariable Long userId,
            @PathVariable Long roomId,
            @RequestBody Booking booking
    ) {
        Booking savedBooking =
                bookingService.addBooking(userId, roomId, booking);

        if (savedBooking == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedBooking);
    }

    // Get all bookings
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(
                bookingService.getAllBookings()
        );
    }

    // Get booking by ID
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(
            @PathVariable Long id
    ) {
        return bookingService.getBookingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get bookings by user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getBookingsByUser(
            @PathVariable Long userId
    ) {
        return ResponseEntity.ok(
                bookingService.getBookingsByUser(userId)
        );
    }

    // Get bookings by room
    @GetMapping("/room/{roomId}")
    public ResponseEntity<List<Booking>> getBookingsByRoom(
            @PathVariable Long roomId
    ) {
        return ResponseEntity.ok(
                bookingService.getBookingsByRoom(roomId)
        );
    }

    // Get bookings by status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Booking>> getBookingsByStatus(
            @PathVariable String status
    ) {
        return ResponseEntity.ok(
                bookingService.getBookingsByStatus(status)
        );
    }

    // Update booking
    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(
            @PathVariable Long id,
            @RequestBody Booking booking
    ) {
        Booking updatedBooking =
                bookingService.updateBooking(id, booking);

        if (updatedBooking == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedBooking);
    }

    // Delete booking
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(
            @PathVariable Long id
    ) {
        boolean deleted = bookingService.deleteBooking(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}