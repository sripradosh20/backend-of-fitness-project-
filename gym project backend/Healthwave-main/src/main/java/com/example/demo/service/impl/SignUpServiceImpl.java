package com.example.demo.service.impl;

import lombok.AllArgsConstructor;
import com.example.demo.dto.SignUpDto;
import com.example.demo.entity.SignUpEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.SignUpMapper;
import com.example.demo.repository.SignUpRepository;
import com.example.demo.service.SignUpService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final SignUpRepository signupRepository;

    @Override
    public SignUpDto createSignUp(SignUpDto signupDto) {
        SignUpEntity signup = SignUpMapper.mapToSignUp(signupDto);
        SignUpEntity savedSignUp = signupRepository.save(signup);
        return SignUpMapper.mapToSignUpDto(savedSignUp);
    }

    @Override
    public SignUpDto getSignUpById(String id) {
        SignUpEntity signup = signupRepository.findById(Long.parseLong(id))
                .orElseThrow(() -> new ResourceNotFoundException("ID does not exist: " + id));
        return SignUpMapper.mapToSignUpDto(signup);
    }

    @Override
    public List<SignUpDto> getAllSignUp() {
        List<SignUpEntity> signups = signupRepository.findAll();
        return signups.stream().map(SignUpMapper::mapToSignUpDto)
                .collect(Collectors.toList());
    }

    @Override
    public SignUpDto updateSignUp(String id, SignUpDto updatedSignUp) {
        SignUpEntity signup = signupRepository.findById(Long.parseLong(id)).orElseThrow(
                () -> new ResourceNotFoundException("ID does not exist: " + id)
        );

        signup.setFullname(updatedSignUp.getFullname());
        
        signup.setEmail(updatedSignUp.getEmail());
        signup.setPassword(updatedSignUp.getPassword());

        SignUpEntity updatedSignUpObj = signupRepository.save(signup);
        return SignUpMapper.mapToSignUpDto(updatedSignUpObj);
    }

    @Override
    public void deleteSignUp(String id) {
        SignUpEntity signup = signupRepository.findById(Long.parseLong(id)).orElseThrow(
                () -> new ResourceNotFoundException("ID does not exist: " + id)
        );

        signupRepository.delete(signup);
    }
}
