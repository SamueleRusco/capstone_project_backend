package com.spring.capstone_project_backend.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.capstone_project_backend.auth.entity.User;
import com.spring.capstone_project_backend.auth.payload.JWTAuthResponse;
import com.spring.capstone_project_backend.auth.payload.LoginDto;
import com.spring.capstone_project_backend.auth.payload.RegisterDto;
import com.spring.capstone_project_backend.auth.repository.UserRepository;
import com.spring.capstone_project_backend.auth.service.AuthService;





@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;
    @Autowired UserRepository userRepo;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
//String role = authService.getRoleByUsername(loginDto.getUsername());
    // Build Login REST API
    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto loginDto){
           	
    	String token = authService.login(loginDto);
    	
    	User u = userRepo.findByUsername(loginDto.getUsername()).get();
        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setUsername(loginDto.getUsername());
        jwtAuthResponse.setAccessToken(token);
        jwtAuthResponse.setRole(u.getRoles());
    
        return ResponseEntity.ok(jwtAuthResponse);
    }

    // Build Register REST API
    @CrossOrigin
    @PostMapping(value = {"/register", "/signup"})
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
