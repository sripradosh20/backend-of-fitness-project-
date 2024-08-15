package com.example.demo.controller;

import lombok.AllArgsConstructor;
import com.example.demo.dto.SignUpDto;
import com.example.demo.service.SignUpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/signup")
public class SignUpController {

    private final SignUpService signupService;

    /**
     * Handles POST requests to create a new sign-up entry.
     *
     * @param signupDto Data Transfer Object containing sign-up details.
     * @return ResponseEntity containing the created SignUpDto and HTTP status CREATED.
     */
    @PostMapping
    public ResponseEntity<SignUpDto> createSignUp(@RequestBody SignUpDto signupDto) {
        SignUpDto savedSignUp = signupService.createSignUp(signupDto);
        return new ResponseEntity<>(savedSignUp, HttpStatus.CREATED);
    }

    /**
     * Handles GET requests to retrieve a sign-up entry by ID.
     *
     * @param id The ID of the sign-up entry.
     * @return ResponseEntity containing the SignUpDto and HTTP status OK.
     */
    @GetMapping("{id}")
    public ResponseEntity<SignUpDto> getSignUpById(@PathVariable("id") String id) {
        SignUpDto signupDto = signupService.getSignUpById(id);
        return ResponseEntity.ok(signupDto);
    }

    /**
     * Handles GET requests to retrieve all sign-up entries.
     *
     * @return ResponseEntity containing a list of SignUpDto and HTTP status OK.
     */
    @GetMapping
    public ResponseEntity<List<SignUpDto>> getAllSignUps() {
        List<SignUpDto> signups = signupService.getAllSignUp();
        return ResponseEntity.ok(signups);
    }

    /**
     * Handles PUT requests to update a sign-up entry by ID.
     *
     * @param id The ID of the sign-up entry.
     * @param updatedSignUp Data Transfer Object containing updated sign-up details.
     * @return ResponseEntity containing the updated SignUpDto and HTTP status OK.
     */
    @PutMapping("{id}")
    public ResponseEntity<SignUpDto> updateSignUp(@PathVariable("id") String id,
                                                  @RequestBody SignUpDto updatedSignUp) {
        SignUpDto signupDto = signupService.updateSignUp(id, updatedSignUp);
        return ResponseEntity.ok(signupDto);
    }

    /**
     * Handles DELETE requests to delete a sign-up entry by ID.
     *
     * @param id The ID of the sign-up entry.
     * @return ResponseEntity containing a success message and HTTP status OK.
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSignUp(@PathVariable("id") String id) {
        signupService.deleteSignUp(id);
        return ResponseEntity.ok("Sign-up entry deleted successfully.");
    }
}
