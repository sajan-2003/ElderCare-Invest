package com.eldernest.repository;

import com.eldernest.entity.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestmentRepository
        extends JpaRepository<Investment, Long> {

    List<Investment> findByInvestorId(Long investorId);
    List<Investment> findByInvestmentPlanId(Long planId);
    List<Investment> findByStatus(String status);
}