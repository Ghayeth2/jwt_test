package com.jwt.practice.models.payload.responses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * LoginResponse used to provide the user who issuing authentication
 * to the system with the valid token to be used for all requests
 * during the session duration.
 */
@Getter @Setter @Builder
public class LoginResponse {
    private String token;
}
