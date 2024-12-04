package com.jwt.practice.models.payload.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * UserRequest is used for registrations payload.
 */

@Getter @Setter @Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotNull(message = "Full name is required!")
    private String fullName;
    @Email(message = "Enter formatted email!")
    @NotNull(message = "Email is required!")
    private String email;
    // Again for more complex system, introduce regex
    @NotNull(message = "Password must be filled!")
    private String password;
}
