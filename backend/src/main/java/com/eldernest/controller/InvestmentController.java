package com.eldernest.controller;

import com.eldernest.entity.Investment;
import com.eldernest.service.InvestmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/investments")
public class InvestmentController {

    private final InvestmentService investmentService;

    public InvestmentController(
            InvestmentService investmentService
    ) {
        this.investmentService = investmentService;
    }

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

        if (savedInvestment == null) {
            return ResponseEntity.badRequest().build();
        }

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
        return investmentService.getInvestmentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/investor/{investorId}")
    public ResponseEntity<List<Investment>> getInvestmentsByInvestor(
            @PathVariable Long investorId
    ) {
        return ResponseEntity.ok(
                investmentService.getInvestmentsByInvestor(investorId)
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
        Investment updatedInvestment =
                investmentService.updateInvestment(id, investment);

        if (updatedInvestment == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedInvestment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvestment(
            @PathVariable Long id
    ) {
        boolean deleted =
                investmentService.deleteInvestment(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}