package com.eldernest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "investments")
public class Investment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal principalAmount;
    private LocalDate startDate;
    private LocalDate maturityDate;
    private String status;

    @ManyToOne
    @JoinColumn(name = "investor_id", nullable = false)
    private Investor investor;

    @ManyToOne
    @JoinColumn(name = "plan_id", nullable = false)
    private InvestmentPlan investmentPlan;
    public Investment() {
    }

}
