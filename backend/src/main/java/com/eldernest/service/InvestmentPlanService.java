package com.eldernest.service;

import com.eldernest.entity.InvestmentPlan;
import com.eldernest.repository.InvestmentPlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvestmentPlanService {

    private final InvestmentPlanRepository investmentPlanRepository;

    public InvestmentPlanService(
            InvestmentPlanRepository investmentPlanRepository
    ) {
        this.investmentPlanRepository = investmentPlanRepository;
    }

    // CREATE
    public InvestmentPlan addInvestmentPlan(
            InvestmentPlan investmentPlan
    ) {
        return investmentPlanRepository.save(investmentPlan);
    }
    // GET ALL
    public List<InvestmentPlan> getAllInvestmentPlans() {
        return investmentPlanRepository.findAll();
    }
    // GET BY ID
    public InvestmentPlan getInvestmentPlanById(Long id) {
        return investmentPlanRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Investment plan not found"));
    }

    // GET ACTIVE PLANS
    public List<InvestmentPlan> getActiveInvestmentPlans() {
        return investmentPlanRepository.findByPlanStatus("ACTIVE");
    }
    // UPDATE
    public InvestmentPlan updateInvestmentPlan(
            Long id,
            InvestmentPlan updatedPlan
    ) {
        InvestmentPlan plan =
                investmentPlanRepository.findById(id).orElseThrow(()->new RuntimeException("Investment plan not found"));

        plan.setPlanName(updatedPlan.getPlanName());
        plan.setDescription(updatedPlan.getDescription());
        plan.setMinimumAmount(updatedPlan.getMinimumAmount());
        plan.setDurationMonths(updatedPlan.getDurationMonths());
        plan.setInterestRate(updatedPlan.getInterestRate());
        plan.setPlanStatus(updatedPlan.getPlanStatus());

        return investmentPlanRepository.save(plan);
    }

    // DELETE
    public void deleteInvestmentPlan(Long id) {

        InvestmentPlan plan = investmentPlanRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Investment plan not found"));

        investmentPlanRepository.delete(plan);
    }
}