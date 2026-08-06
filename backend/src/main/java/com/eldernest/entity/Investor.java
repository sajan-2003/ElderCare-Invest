package com.eldernest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "investors")
public class Investor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String occupation;
    private BigDecimal annualIncome;
    private String riskProfile;
    private String nextOfKinName;
    private String nextOfKinPhone;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Investor() {
    }
}