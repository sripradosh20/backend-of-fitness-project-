package com.example.demo.controller;

import com.example.demo.dto.PremiumPlanDto;
import com.example.demo.service.PremiumPlanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/premium-plans")
public class PremiumPlanController {

    private final PremiumPlanService premiumPlanService;

    @PostMapping
    public ResponseEntity<PremiumPlanDto> createPremiumPlan(@RequestBody PremiumPlanDto premiumPlanDto) {
        PremiumPlanDto savedPremiumPlan = premiumPlanService.createPremiumPlan(premiumPlanDto);
        return new ResponseEntity<>(savedPremiumPlan, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<PremiumPlanDto> getPremiumPlanById(@PathVariable("id") Long id) {
        PremiumPlanDto premiumPlanDto = premiumPlanService.getPremiumPlanById(id);
        return ResponseEntity.ok(premiumPlanDto);
    }

    @GetMapping
    public ResponseEntity<List<PremiumPlanDto>> getAllPremiumPlans() {
        List<PremiumPlanDto> premiumPlans = premiumPlanService.getAllPremiumPlans();
        return ResponseEntity.ok(premiumPlans);
    }

    @PutMapping("{id}")
    public ResponseEntity<PremiumPlanDto> updatePremiumPlan(@PathVariable("id") Long id,
                                                            @RequestBody PremiumPlanDto premiumPlanDto) {
        PremiumPlanDto updatedPremiumPlan = premiumPlanService.updatePremiumPlan(id, premiumPlanDto);
        return ResponseEntity.ok(updatedPremiumPlan);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePremiumPlan(@PathVariable("id") Long id) {
        premiumPlanService.deletePremiumPlan(id);
        return ResponseEntity.ok("Premium Plan deleted successfully.");
    }
}
