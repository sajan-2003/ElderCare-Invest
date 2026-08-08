package com.eldernest.controller;

import com.eldernest.entity.InvestmentPlan;
import com.eldernest.service.InvestmentPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/investment-plans")
@RequiredArgsConstructor
public class InvestmentPlanController {

    private final InvestmentPlanService investmentPlanService;

    // CREATE
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

    // GET ALL
    @GetMapping
    public ResponseEntity<List<InvestmentPlan>> getAllInvestmentPlans() {
        return ResponseEntity.ok(
                investmentPlanService.getAllInvestmentPlans()
        );
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<InvestmentPlan> getInvestmentPlanById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                investmentPlanService.getInvestmentPlanById(id)
        );
    }

    // GET ACTIVE PLANS
    @GetMapping("/active")
    public ResponseEntity<List<InvestmentPlan>> getActiveInvestmentPlans() {
        return ResponseEntity.ok(
                investmentPlanService.getActiveInvestmentPlans()
        );
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<InvestmentPlan> updateInvestmentPlan(
            @PathVariable Long id,
            @RequestBody InvestmentPlan investmentPlan
    ) {
        return ResponseEntity.ok(
                investmentPlanService.updateInvestmentPlan(
                        id,
                        investmentPlan
                )
        );
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvestmentPlan(
            @PathVariable Long id
    ) {
        investmentPlanService.deleteInvestmentPlan(id);
        return ResponseEntity.noContent().build();
    }
}