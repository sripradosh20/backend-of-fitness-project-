package com.example.demo.service;

import com.example.demo.dto.SignUpDto;

import java.util.List;

public interface SignUpService {

    SignUpDto createSignUp(SignUpDto signupDto);

    SignUpDto getSignUpById(String id);  // Updated method name and parameter

    List<SignUpDto> getAllSignUp();

    SignUpDto updateSignUp(String id, SignUpDto updatedSignUp);  // Updated method parameter

    void deleteSignUp(String id);  // Updated method parameter
}
