package com.example.demo.mapper;

import com.example.demo.dto.RegistrationDto;
import com.example.demo.entity.RegistrationEntity;

public class RegistrationMapper {

    public static RegistrationDto mapToRegistrationDto(RegistrationEntity registration) {
        return new RegistrationDto(
                registration.getId(),
                registration.getFullname(),
                registration.getEmail(),
                registration.getPassword()
        );
    }

    public static RegistrationEntity mapToRegistration(RegistrationDto registrationDto) {
        return new RegistrationEntity(
                registrationDto.getId(),
                registrationDto.getFullname(),
                registrationDto.getEmail(),
                registrationDto.getPassword()
        );
    }
}
