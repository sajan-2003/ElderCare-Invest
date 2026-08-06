package com.eldernest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomNumber;
    private String roomType;
    private int capacity;
    private BigDecimal monthlyPrice;
    private boolean available;

    @ManyToOne
    @JoinColumn(name = "facility_id", nullable = false)
    private Facility facility;

    public Room() {
    }

    public Room(
            String roomNumber,
            String roomType,
            int capacity,
            BigDecimal monthlyPrice,
            boolean available,
            Facility facility
    ) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.capacity = capacity;
        this.monthlyPrice = monthlyPrice;
        this.available = available;
        this.facility = facility;
    }
}