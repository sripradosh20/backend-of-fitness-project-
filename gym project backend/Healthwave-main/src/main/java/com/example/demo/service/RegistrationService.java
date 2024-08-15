package com.example.demo.service;

import com.example.demo.dto.RegistrationDto;

import java.util.List;

public interface RegistrationService {

    RegistrationDto createRegistration(RegistrationDto registrationDto);

    RegistrationDto getRegistrationById(String id);

    List<RegistrationDto> getAllRegistrations();

    RegistrationDto updateRegistration(String id, RegistrationDto updatedRegistration);

    void deleteRegistration(String id);
}
