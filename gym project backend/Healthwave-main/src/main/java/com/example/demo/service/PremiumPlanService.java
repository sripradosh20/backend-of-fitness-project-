package com.example.demo.service;


import com.example.demo.dto.PremiumPlanDto;

import java.util.List;

public interface PremiumPlanService {
    PremiumPlanDto createPremiumPlan(PremiumPlanDto premiumPlanDto);
    PremiumPlanDto getPremiumPlanById(Long id);
    List<PremiumPlanDto> getAllPremiumPlans();
    PremiumPlanDto updatePremiumPlan(Long id, PremiumPlanDto premiumPlanDto);
    void deletePremiumPlan(Long id);
}
