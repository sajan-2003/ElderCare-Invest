package com.eldernest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "facilities")
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String description;
    private String contactNumber;
    private String email;
    private int capacity;
    private boolean active;

    public Facility() {
    }

    public Facility(
            String name,
            String location,
            String description,
            String contactNumber,
            String email,
            int capacity,
            boolean active
    ) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.contactNumber = contactNumber;
        this.email = email;
        this.capacity = capacity;
        this.active = active;
    }
}