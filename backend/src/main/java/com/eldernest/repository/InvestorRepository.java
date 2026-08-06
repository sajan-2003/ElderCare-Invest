package com.eldernest.repository;

import com.eldernest.entity.Investor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestorRepository extends JpaRepository<Investor,Long> {

}

