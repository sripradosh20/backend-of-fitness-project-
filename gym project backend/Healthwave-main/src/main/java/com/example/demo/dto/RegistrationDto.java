package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {

    private Long id;

    @JsonProperty("full_name")
    private String fullname;

    @JsonProperty("email_id")
    private String email;

    @JsonProperty("password")
    private String password;
}
