package com.example.demo.controller;

import lombok.AllArgsConstructor;
import com.example.demo.dto.RegistrationDto;
import com.example.demo.service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000/")
@AllArgsConstructor
@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<RegistrationDto> createRegistration(@RequestBody RegistrationDto registrationDto) {
        RegistrationDto savedRegistration = registrationService.createRegistration(registrationDto);
        return new ResponseEntity<>(savedRegistration, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<RegistrationDto> getRegistrationById(@PathVariable("id") String id) {
        RegistrationDto registrationDto = registrationService.getRegistrationById(id);
        return ResponseEntity.ok(registrationDto);
    }

    @GetMapping
    public ResponseEntity<List<RegistrationDto>> getAllRegistrations() {
        List<RegistrationDto> registrations = registrationService.getAllRegistrations();
        return ResponseEntity.ok(registrations);
    }

    @PutMapping("{id}")
    public ResponseEntity<RegistrationDto> updateRegistration(@PathVariable("id") String id,
                                                              @RequestBody RegistrationDto updatedRegistration) {
        RegistrationDto registrationDto = registrationService.updateRegistration(id, updatedRegistration);
        return ResponseEntity.ok(registrationDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRegistration(@PathVariable("id") String id) {
        registrationService.deleteRegistration(id);
        return ResponseEntity.ok("Registration entry deleted successfully.");
    }
}
