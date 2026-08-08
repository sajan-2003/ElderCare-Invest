package com.eldernest.service;

import com.eldernest.entity.Investment;
import com.eldernest.entity.InvestmentPlan;
import com.eldernest.entity.Investor;
import com.eldernest.repository.InvestmentPlanRepository;
import com.eldernest.repository.InvestmentRepository;
import com.eldernest.repository.InvestorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvestmentService {

    private final InvestmentRepository investmentRepository;
    private final InvestorRepository investorRepository;
    private final InvestmentPlanRepository investmentPlanRepository;

    // CREATE
    public Investment addInvestment(
            Long investorId,
            Long planId,
            Investment investment
    ) {

        Investor investor = investorRepository.findById(investorId)
                .orElseThrow(() ->
                        new RuntimeException("Investor not found"));

        InvestmentPlan plan = investmentPlanRepository.findById(planId)
                .orElseThrow(() ->
                        new RuntimeException("Investment plan not found"));

        if (investment.getPrincipalAmount() == null) {
            throw new RuntimeException("Principal amount is required");
        }

        if (investment.getPrincipalAmount()
                .compareTo(plan.getMinimumAmount()) < 0) {

            throw new RuntimeException(
                    "Investment amount must be at least "
                            + plan.getMinimumAmount()
            );
        }

        investment.setInvestor(investor);
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

    // GET ALL
    public List<Investment> getAllInvestments() {
        return investmentRepository.findAll();
    }

    // GET BY ID
    public Investment getInvestmentById(Long id) {
        return investmentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Investment not found"));
    }

    // GET BY INVESTOR
    public List<Investment> getInvestmentsByInvestor(Long investorId) {
        return investmentRepository.findByInvestorId(investorId);
    }

    // GET BY PLAN
    public List<Investment> getInvestmentsByPlan(Long planId) {
        return investmentRepository.findByInvestmentPlanId(planId);
    }

    // GET BY STATUS
    public List<Investment> getInvestmentsByStatus(String status) {
        return investmentRepository.findByStatus(status);
    }

    // UPDATE
    public Investment updateInvestment(
            Long id,
            Investment updatedInvestment
    ) {

        Investment investment = investmentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Investment not found"));

        investment.setPrincipalAmount(
                updatedInvestment.getPrincipalAmount()
        );

        investment.setStartDate(
                updatedInvestment.getStartDate()
        );

        investment.setMaturityDate(
                updatedInvestment.getMaturityDate()
        );

        investment.setStatus(
                updatedInvestment.getStatus()
        );

        return investmentRepository.save(investment);
    }

    // DELETE
    public void deleteInvestment(Long id) {

        Investment investment = investmentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Investment not found"));

        investmentRepository.delete(investment);
    }
}