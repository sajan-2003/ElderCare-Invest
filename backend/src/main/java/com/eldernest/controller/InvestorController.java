package com.eldernest.controller;

import com.eldernest.entity.Investor;
import com.eldernest.service.InvestorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/investors")
public class InvestorController {

    private final InvestorService investorService;

    public InvestorController(InvestorService investorService) {
        this.investorService = investorService;
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<Investor> addInvestor(
            @PathVariable Long userId,
            @RequestBody Investor investor
    ) {
        Investor savedInvestor =
                investorService.addInvestor(userId, investor);

        if (savedInvestor == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedInvestor);
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
        return investorService.getInvestorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Investor> updateInvestor(
            @PathVariable Long id,
            @RequestBody Investor investor
    ) {
        Investor updatedInvestor =
                investorService.updateInvestor(id, investor);

        if (updatedInvestor == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedInvestor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvestor(
            @PathVariable Long id
    ) {
        boolean deleted = investorService.deleteInvestor(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}