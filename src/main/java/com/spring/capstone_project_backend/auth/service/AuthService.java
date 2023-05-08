package com.spring.capstone_project_backend.auth.service;

import com.spring.capstone_project_backend.auth.payload.LoginDto;
import com.spring.capstone_project_backend.auth.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
