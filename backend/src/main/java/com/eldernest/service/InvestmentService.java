package com.eldernest.service;

import com.eldernest.entity.Investment;
import com.eldernest.entity.InvestmentPlan;
import com.eldernest.entity.Investor;
import com.eldernest.repository.InvestmentPlanRepository;
import com.eldernest.repository.InvestmentRepository;
import com.eldernest.repository.InvestorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class InvestmentService {

    private final InvestmentRepository investmentRepository;
    private final InvestorRepository investorRepository;
    private final InvestmentPlanRepository investmentPlanRepository;

    public InvestmentService(
            InvestmentRepository investmentRepository,
            InvestorRepository investorRepository,
            InvestmentPlanRepository investmentPlanRepository
    ) {
        this.investmentRepository = investmentRepository;
        this.investorRepository = investorRepository;
        this.investmentPlanRepository = investmentPlanRepository;
    }

    public Investment addInvestment(
            Long investorId,
            Long planId,
            Investment investment
    ) {
        Optional<Investor> existingInvestor =
                investorRepository.findById(investorId);

        Optional<InvestmentPlan> existingPlan =
                investmentPlanRepository.findById(planId);

        if (existingInvestor.isEmpty() || existingPlan.isEmpty()) {
            return null;
        }

        InvestmentPlan plan = existingPlan.get();

        if (investment.getPrincipalAmount() == null ||
                investment.getPrincipalAmount()
                        .compareTo(plan.getMinimumAmount()) < 0) {
            return null;
        }

        investment.setInvestor(existingInvestor.get());
        investment.setInvestmentPlan(plan);

        if (investment.getStartDate() == null) {
            investment.setStartDate(LocalDate.now());
        }

        if (investment.getMaturityDate() == null) {
            investment.setMaturityDate(
                    investment.getStartDate()
                            .plusMonths(plan.getDurationMonths())
            );
        }

        if (investment.getStatus() == null ||
                investment.getStatus().isBlank()) {
            investment.setStatus("ACTIVE");
        }

        return investmentRepository.save(investment);
    }

    public List<Investment> getAllInvestments() {
        return investmentRepository.findAll();
    }

    public Optional<Investment> getInvestmentById(Long id) {
        return investmentRepository.findById(id);
    }

    public List<Investment> getInvestmentsByInvestor(Long investorId) {
        return investmentRepository.findByInvestorId(investorId);
    }

    public List<Investment> getInvestmentsByPlan(Long planId) {
        return investmentRepository.findByInvestmentPlanId(planId);
    }

    public List<Investment> getInvestmentsByStatus(String status) {
        return investmentRepository.findByStatus(status);
    }

    public Investment updateInvestment(
            Long id,
            Investment updatedInvestment
    ) {
        Optional<Investment> existingInvestment =
                investmentRepository.findById(id);

        if (existingInvestment.isEmpty()) {
            return null;
        }

        Investment investment = existingInvestment.get();

        investment.setPrincipalAmount(
                updatedInvestment.getPrincipalAmount()
        );
        investment.setStartDate(updatedInvestment.getStartDate());
        investment.setMaturityDate(updatedInvestment.getMaturityDate());
        investment.setStatus(updatedInvestment.getStatus());

        return investmentRepository.save(investment);
    }

    public boolean deleteInvestment(Long id) {
        if (!investmentRepository.existsById(id)) {
            return false;
        }

        investmentRepository.deleteById(id);
        return true;
    }
}