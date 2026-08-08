package com.eldernest.service;

import com.eldernest.entity.Investor;
import com.eldernest.repository.InvestorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvestorService {

    private final InvestorRepository investorRepository;

    public Investor addInvestor(Investor investor) {
        return investorRepository.save(investor);
    }

    public List<Investor> getAllInvestors() {
        return investorRepository.findAll();
    }

    public Investor getInvestorById(Long id) {
        return investorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Investor not found"));
    }

    public Investor updateInvestor(Long id, Investor investorDetails) {

        Investor investor = investorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Investor not found"));

        investor.setOccupation(investorDetails.getOccupation());
        investor.setAnnualIncome(investorDetails.getAnnualIncome());
        investor.setRiskProfile(investorDetails.getRiskProfile());
        investor.setUser(investorDetails.getUser());

        return investorRepository.save(investor);
    }

    public void deleteInvestor(Long id) {

        Investor investor = investorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Investor not found"));

        investorRepository.delete(investor);
    }
}