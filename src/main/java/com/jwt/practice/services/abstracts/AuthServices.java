package com.jwt.practice.services.abstracts;

import com.jwt.practice.models.payload.requests.LoginRequest;
import com.jwt.practice.models.payload.responses.LoginResponse;

public interface AuthServices {
    /**
     *
     * @param loginRequest
     * @return
     */
    LoginResponse login(LoginRequest loginRequest);
}
