package com.eldernest.controller;

import com.eldernest.entity.Investor;
import com.eldernest.service.InvestorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/investors")
@RequiredArgsConstructor
public class InvestorController {

    private final InvestorService investorService;

    @PostMapping
    public ResponseEntity<Investor> addInvestor(
            @RequestBody Investor investor
    ) {
        return ResponseEntity.ok(
                investorService.addInvestor(investor)
        );
    }

    @GetMapping
    public ResponseEntity<List<Investor>> getAllInvestors() {
        return ResponseEntity.ok(
                investorService.getAllInvestors()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Investor> getInvestorById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                investorService.getInvestorById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Investor> updateInvestor(
            @PathVariable Long id,
            @RequestBody Investor investor
    ) {
        return ResponseEntity.ok(
                investorService.updateInvestor(id, investor)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvestor(
            @PathVariable Long id
    ) {
        investorService.deleteInvestor(id);
        return ResponseEntity.noContent().build();
    }
}