package com.eldernest.repository;

import com.eldernest.entity.Investment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvestmentRepository
        extends JpaRepository<Investment, Long> {

    List<Investment> findByInvestorId(Long investorId);
    List<Investment> findByInvestmentPlanId(Long planId);
    List<Investment> findByStatus(String status);
}