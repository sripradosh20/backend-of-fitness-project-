package com.example.demo.mapper;

import com.example.demo.dto.PremiumPlanDto;
import com.example.demo.entity.PremiumPlan;

public class PremiumPlanMapper {

    public static PremiumPlanDto mapToPremiumPlanDto(PremiumPlan premiumPlan) {
        return new PremiumPlanDto(
                premiumPlan.getId(),
                premiumPlan.getPlanName(),
                premiumPlan.getDescription(),
                premiumPlan.getPrice()
        );
    }

    public static PremiumPlan mapToPremiumPlan(PremiumPlanDto premiumPlanDto) {
        return new PremiumPlan(
                premiumPlanDto.getId(),
                premiumPlanDto.getPlanName(),
                premiumPlanDto.getDescription(),
                premiumPlanDto.getPrice()
        );
    }
}
