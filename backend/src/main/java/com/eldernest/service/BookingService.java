package com.eldernest.service;

import com.eldernest.entity.Booking;
import com.eldernest.entity.Room;
import com.eldernest.entity.User;
import com.eldernest.repository.BookingRepository;
import com.eldernest.repository.RoomRepository;
import com.eldernest.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    public BookingService(
            BookingRepository bookingRepository,
            UserRepository userRepository,
            RoomRepository roomRepository
    ) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
    }

    // Create booking
    public Booking addBooking(
            Long userId,
            Long roomId,
            Booking booking
    ) {
        Optional<User> existingUser = userRepository.findById(userId);
        Optional<Room> existingRoom = roomRepository.findById(roomId);

        if (existingUser.isEmpty() || existingRoom.isEmpty()) {
            return null;
        }

        Room room = existingRoom.get();

        if (!room.isAvailable()) {
            return null;
        }

        if (booking.getCheckInDate() == null ||
                booking.getCheckOutDate() == null) {
            return null;
        }

        if (booking.getCheckOutDate()
                .isBefore(booking.getCheckInDate())) {
            return null;
        }

        booking.setUser(existingUser.get());
        booking.setRoom(room);

        if (booking.getBookingDate() == null) {
            booking.setBookingDate(LocalDate.now());
        }

        if (booking.getStatus() == null ||
                booking.getStatus().isBlank()) {
            booking.setStatus("PENDING");
        }

        Booking savedBooking = bookingRepository.save(booking);

        room.setAvailable(false);
        roomRepository.save(room);

        return savedBooking;
    }
    // Get all
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Get by ID
    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    // Get by user
    public List<Booking> getBookingsByUser(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    // Get by room
    public List<Booking> getBookingsByRoom(Long roomId) {
        return bookingRepository.findByRoomId(roomId);
    }

    // Get by status
    public List<Booking> getBookingsByStatus(String status) {
        return bookingRepository.findByStatus(status);
    }

    // Update
    public Booking updateBooking(
            Long id,
            Booking updatedBooking
    ) {
        Optional<Booking> existingBooking =
                bookingRepository.findById(id);

        if (existingBooking.isEmpty()) {
            return null;
        }

        Booking booking = existingBooking.get();

        booking.setBookingDate(updatedBooking.getBookingDate());
        booking.setCheckInDate(updatedBooking.getCheckInDate());
        booking.setCheckOutDate(updatedBooking.getCheckOutDate());
        booking.setStatus(updatedBooking.getStatus());
        booking.setTotalAmount(updatedBooking.getTotalAmount());

        return bookingRepository.save(booking);
    }

    // Delete
    public boolean deleteBooking(Long id) {
        if (!bookingRepository.existsById(id)) {
            return false;
        }

        bookingRepository.deleteById(id);
        return true;
    }
}