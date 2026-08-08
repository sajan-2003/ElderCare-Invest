package com.eldernest.controller;

import com.eldernest.entity.Investment;
import com.eldernest.service.InvestmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/investments")
@RequiredArgsConstructor
public class InvestmentController {

    private final InvestmentService investmentService;

    @PostMapping("/investor/{investorId}/plan/{planId}")
    public ResponseEntity<Investment> addInvestment(
            @PathVariable Long investorId,
            @PathVariable Long planId,
            @RequestBody Investment investment
    ) {

        Investment savedInvestment =
                investmentService.addInvestment(
                        investorId,
                        planId,
                        investment
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedInvestment);
    }

    @GetMapping
    public ResponseEntity<List<Investment>> getAllInvestments() {
        return ResponseEntity.ok(
                investmentService.getAllInvestments()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Investment> getInvestmentById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                investmentService.getInvestmentById(id)
        );
    }

    @GetMapping("/investor/{investorId}")
    public ResponseEntity<List<Investment>> getInvestmentsByInvestor(
            @PathVariable Long investorId
    ) {
        return ResponseEntity.ok(
                investmentService
                        .getInvestmentsByInvestor(investorId)
        );
    }

    @GetMapping("/plan/{planId}")
    public ResponseEntity<List<Investment>> getInvestmentsByPlan(
            @PathVariable Long planId
    ) {
        return ResponseEntity.ok(
                investmentService.getInvestmentsByPlan(planId)
        );
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Investment>> getInvestmentsByStatus(
            @PathVariable String status
    ) {
        return ResponseEntity.ok(
                investmentService.getInvestmentsByStatus(status)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Investment> updateInvestment(
            @PathVariable Long id,
            @RequestBody Investment investment
    ) {
        return ResponseEntity.ok(
                investmentService.updateInvestment(id, investment)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvestment(
            @PathVariable Long id
    ) {
        investmentService.deleteInvestment(id);

        return ResponseEntity.noContent().build();
    }
}