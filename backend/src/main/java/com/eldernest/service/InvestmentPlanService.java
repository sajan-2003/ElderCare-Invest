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

    public InvestmentPlan addInvestmentPlan(
            InvestmentPlan investmentPlan
    ) {
        return investmentPlanRepository.save(investmentPlan);
    }

    public List<InvestmentPlan> getAllInvestmentPlans() {
        return investmentPlanRepository.findAll();
    }

    public Optional<InvestmentPlan> getInvestmentPlanById(Long id) {
        return investmentPlanRepository.findById(id);
    }

    public List<InvestmentPlan> getActiveInvestmentPlans() {
        return investmentPlanRepository.findByPlanStatus("ACTIVE");
    }

    public InvestmentPlan updateInvestmentPlan(
            Long id,
            InvestmentPlan updatedPlan
    ) {
        Optional<InvestmentPlan> existingPlan =
                investmentPlanRepository.findById(id);

        if (existingPlan.isEmpty()) {
            return null;
        }

        InvestmentPlan plan = existingPlan.get();

        plan.setPlanName(updatedPlan.getPlanName());
        plan.setDescription(updatedPlan.getDescription());
        plan.setMinimumAmount(updatedPlan.getMinimumAmount());
        plan.setDurationMonths(updatedPlan.getDurationMonths());
        plan.setInterestRate(updatedPlan.getInterestRate());
        plan.setPlanStatus(updatedPlan.getPlanStatus());

        return investmentPlanRepository.save(plan);
    }

    public boolean deleteInvestmentPlan(Long id) {
        if (!investmentPlanRepository.existsById(id)) {
            return false;
        }

        investmentPlanRepository.deleteById(id);
        return true;
    }
}