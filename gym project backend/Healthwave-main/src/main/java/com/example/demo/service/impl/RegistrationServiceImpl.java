package com.example.demo.service.impl;

import lombok.AllArgsConstructor;
import com.example.demo.dto.RegistrationDto;
import com.example.demo.entity.RegistrationEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.RegistrationMapper;
import com.example.demo.repository.RegistrationRepository;
import com.example.demo.service.RegistrationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;

    @Override
    public RegistrationDto createRegistration(RegistrationDto registrationDto) {
        RegistrationEntity registration = RegistrationMapper.mapToRegistration(registrationDto);
        RegistrationEntity savedRegistration = registrationRepository.save(registration);
        return RegistrationMapper.mapToRegistrationDto(savedRegistration);
    }

    @Override
    public RegistrationDto getRegistrationById(String id) {
        RegistrationEntity registration = registrationRepository.findById(Long.parseLong(id))
                .orElseThrow(() -> new ResourceNotFoundException("ID does not exist: " + id));
        return RegistrationMapper.mapToRegistrationDto(registration);
    }

    @Override
    public List<RegistrationDto> getAllRegistrations() {
        List<RegistrationEntity> registrations = registrationRepository.findAll();
        return registrations.stream().map(RegistrationMapper::mapToRegistrationDto)
                .collect(Collectors.toList());
    }

    @Override
    public RegistrationDto updateRegistration(String id, RegistrationDto updatedRegistration) {
        RegistrationEntity registration = registrationRepository.findById(Long.parseLong(id)).orElseThrow(
                () -> new ResourceNotFoundException("ID does not exist: " + id)
        );

        registration.setFullname(updatedRegistration.getFullname());
        registration.setEmail(updatedRegistration.getEmail());
        registration.setPassword(updatedRegistration.getPassword());

        RegistrationEntity updatedRegistrationObj = registrationRepository.save(registration);
        return RegistrationMapper.mapToRegistrationDto(updatedRegistrationObj);
    }

    @Override
    public void deleteRegistration(String id) {
        RegistrationEntity registration = registrationRepository.findById(Long.parseLong(id)).orElseThrow(
                () -> new ResourceNotFoundException("ID does not exist: " + id)
        );

        registrationRepository.delete(registration);
    }
}
