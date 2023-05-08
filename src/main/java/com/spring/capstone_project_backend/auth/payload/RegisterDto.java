package com.spring.capstone_project_backend.auth.payload;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    private String name;
    private String username;
    private String email;
    private String password;
    private String secretCode;
    private String creditCard;
 // Per registrare tutti come USER di Default commentare roles
    private Set<String> roles;
}
