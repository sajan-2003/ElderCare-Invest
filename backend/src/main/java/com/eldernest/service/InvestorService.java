package com.eldernest.service;

import com.eldernest.entity.Investor;
import com.eldernest.entity.User;
import com.eldernest.repository.InvestorRepository;
import com.eldernest.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvestorService {

    private final InvestorRepository investorRepository;
    private final UserRepository userRepository;

    public InvestorService(
            InvestorRepository investorRepository,
            UserRepository userRepository
    ) {
        this.investorRepository = investorRepository;
        this.userRepository = userRepository;
    }

    public Investor addInvestor(Long userId, Investor investor) {

        Optional<User> existingUser = userRepository.findById(userId);

        if (existingUser.isEmpty()) {
            return null;
        }

        investor.setUser(existingUser.get());

        return investorRepository.save(investor);
    }

    public List<Investor> getAllInvestors() {
        return investorRepository.findAll();
    }

    public Optional<Investor> getInvestorById(Long id) {
        return investorRepository.findById(id);
    }

    public Investor updateInvestor(Long id, Investor updatedInvestor) {

        Optional<Investor> existingInvestor =
                investorRepository.findById(id);

        if (existingInvestor.isEmpty()) {
            return null;
        }

        Investor investor = existingInvestor.get();

        investor.setAnnualIncome(updatedInvestor.getAnnualIncome());
        investor.setOccupation(updatedInvestor.getOccupation());
        investor.setRiskProfile(updatedInvestor.getRiskProfile());
        investor.setNextOfKinName(updatedInvestor.getNextOfKinName());
        investor.setNextOfKinPhone(updatedInvestor.getNextOfKinPhone());

        return investorRepository.save(investor);
    }

    public boolean deleteInvestor(Long id) {

        if (!investorRepository.existsById(id)) {
            return false;
        }

        investorRepository.deleteById(id);
        return true;
    }
}