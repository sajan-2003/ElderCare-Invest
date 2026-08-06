package com.eldernest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "investment_plans")
public class InvestmentPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String planName;
    private String description;
    private BigDecimal minimumAmount;
    private int durationMonths;
    private BigDecimal interestRate;
    private String planStatus;

    public InvestmentPlan() {
    }
}