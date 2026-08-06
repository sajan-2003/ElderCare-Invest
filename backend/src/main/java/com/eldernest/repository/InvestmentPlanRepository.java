package com.eldernest.repository;

import com.eldernest.entity.InvestmentPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvestmentPlanRepository
        extends JpaRepository<InvestmentPlan, Long> {
    List<InvestmentPlan> findByPlanStatus(String planStatus);
}