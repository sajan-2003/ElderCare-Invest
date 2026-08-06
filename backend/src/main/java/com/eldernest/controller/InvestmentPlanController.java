package com.eldernest.controller;

import com.eldernest.entity.InvestmentPlan;
import com.eldernest.service.InvestmentPlanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/investment-plans")
public class InvestmentPlanController {

    private final InvestmentPlanService investmentPlanService;

    public InvestmentPlanController(
            InvestmentPlanService investmentPlanService
    ) {
        this.investmentPlanService = investmentPlanService;
    }

    @PostMapping
    public ResponseEntity<InvestmentPlan> addInvestmentPlan(
            @RequestBody InvestmentPlan investmentPlan
    ) {
        InvestmentPlan savedPlan =
                investmentPlanService.addInvestmentPlan(investmentPlan);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedPlan);
    }

    @GetMapping
    public ResponseEntity<List<InvestmentPlan>> getAllInvestmentPlans() {
        return ResponseEntity.ok(
                investmentPlanService.getAllInvestmentPlans()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvestmentPlan> getInvestmentPlanById(
            @PathVariable Long id
    ) {
        return investmentPlanService.getInvestmentPlanById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/active")
    public ResponseEntity<List<InvestmentPlan>> getActiveInvestmentPlans() {
        return ResponseEntity.ok(
                investmentPlanService.getActiveInvestmentPlans()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvestmentPlan> updateInvestmentPlan(
            @PathVariable Long id,
            @RequestBody InvestmentPlan investmentPlan
    ) {
        InvestmentPlan updatedPlan =
                investmentPlanService.updateInvestmentPlan(
                        id,
                        investmentPlan
                );

        if (updatedPlan == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedPlan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvestmentPlan(
            @PathVariable Long id
    ) {
        boolean deleted =
                investmentPlanService.deleteInvestmentPlan(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}