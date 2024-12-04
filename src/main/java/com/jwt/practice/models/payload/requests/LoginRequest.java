package com.jwt.practice.models.payload.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * LoginRequest is used to get the credentials of the user
 * for an auth process (email and password).
 */

@Getter @Setter @Builder
public class LoginRequest {
    @Email(message = "Enter email formatted text!")
    @NotNull(message = "Username is required!")
    private String username;
    // for more complex apps, add regex
    @NotNull(message = "Password is required!")
    private String password;
}
