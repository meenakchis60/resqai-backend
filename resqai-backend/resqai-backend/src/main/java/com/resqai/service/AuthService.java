package com.resqai.service;

import com.resqai.dto.request.LoginRequest;
import com.resqai.dto.request.RegisterRequest;
import com.resqai.dto.response.AuthResponse;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);

}