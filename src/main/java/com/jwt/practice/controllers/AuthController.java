package com.jwt.practice.controllers;

import com.jwt.practice.models.payload.requests.LoginRequest;
import com.jwt.practice.models.payload.requests.UserRequest;
import com.jwt.practice.models.payload.responses.LoginResponse;
import com.jwt.practice.security.JwtIssuer;
import com.jwt.practice.services.abstracts.AuthServices;
import com.jwt.practice.services.abstracts.UserServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Used for authenticating users (login and sign up)
 */


@RequestMapping("/api/auth")
@RestController
@RequiredArgsConstructor // injects only final fields
public class AuthController {
    private final AuthServices authServices;

    private final UserServices userServices;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody  LoginRequest request) {
        return new ResponseEntity<>(authServices.login(request), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody  UserRequest request) {
        return new ResponseEntity<>(userServices.save(request), HttpStatus.CREATED);
    }
}



