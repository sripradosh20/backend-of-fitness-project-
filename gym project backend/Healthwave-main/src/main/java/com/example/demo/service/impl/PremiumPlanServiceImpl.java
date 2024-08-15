

package com.example.demo.service.impl;

import com.example.demo.dto.PremiumPlanDto;
import com.example.demo.entity.PremiumPlan;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.PremiumPlanMapper;
import com.example.demo.repository.PremiumPlanRepository;
import com.example.demo.service.PremiumPlanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PremiumPlanServiceImpl implements PremiumPlanService {
	
    private final PremiumPlanRepository premiumPlanRepository;

    @Override
    public PremiumPlanDto createPremiumPlan(PremiumPlanDto premiumPlanDto) {
        PremiumPlan premiumPlan = PremiumPlanMapper.mapToPremiumPlan(premiumPlanDto);
        PremiumPlan savedPremiumPlan = premiumPlanRepository.save(premiumPlan);
        return PremiumPlanMapper.mapToPremiumPlanDto(savedPremiumPlan);
    }

    @Override
    public PremiumPlanDto getPremiumPlanById(Long id) {
        PremiumPlan premiumPlan = premiumPlanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Premium Plan not found with id: " + id));
        return PremiumPlanMapper.mapToPremiumPlanDto(premiumPlan);
    }

    @Override
    public List<PremiumPlanDto> getAllPremiumPlans() {
        return premiumPlanRepository.findAll().stream()
                .map(PremiumPlanMapper::mapToPremiumPlanDto)
                .collect(Collectors.toList());
    }

    @Override
    public PremiumPlanDto updatePremiumPlan(Long id, PremiumPlanDto premiumPlanDto) {
        PremiumPlan premiumPlan = premiumPlanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Premium Plan not found with id: " + id));

        premiumPlan.setPlanName(premiumPlanDto.getPlanName());
        premiumPlan.setDescription(premiumPlanDto.getDescription());
        premiumPlan.setPrice(premiumPlanDto.getPrice());

        PremiumPlan updatedPremiumPlan = premiumPlanRepository.save(premiumPlan);
        return PremiumPlanMapper.mapToPremiumPlanDto(updatedPremiumPlan);
    }

    @Override
    public void deletePremiumPlan(Long id) {
        PremiumPlan premiumPlan = premiumPlanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Premium Plan not found with id: " + id));
        premiumPlanRepository.delete(premiumPlan);
    }
}
