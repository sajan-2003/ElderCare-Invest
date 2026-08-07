package com.eldernest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "services")
public class FacilityService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "facility_id", nullable = false)
    private Facility facility;

    @Column(name = "service_name", nullable = false)
    private String serviceName;

    @Column(length = 500)
    private String description;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal cost;

    private String category;

    @Column(name = "service_status", nullable = false)
    private String serviceStatus;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public FacilityService() {
    }

    public FacilityService(
            Facility facility,
            String serviceName,
            String description,
            BigDecimal cost,
            String category,
            String serviceStatus
    ) {
        this.facility = facility;
        this.serviceName = serviceName;
        this.description = description;
        this.cost = cost;
        this.category = category;
        this.serviceStatus = serviceStatus;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}