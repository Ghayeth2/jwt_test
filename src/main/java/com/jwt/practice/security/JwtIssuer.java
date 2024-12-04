package com.jwt.practice.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Documentation for your code in Spring Boot
 * Explain what you wrote in here, so the user of your class
 * or code in anywhere of the App will know what is for.
 *
 * JwtIssuer is to issue a token when a valid credentials are provided
 * during login process. It will return a token for the user to use it
 * for all his / her requests to the API during the valid session duration
 */
@RequiredArgsConstructor
@Component
public class JwtIssuer {
    private final JwtProperties properties;
    public String issuer(Long id, String email, List<String> roles) {
        return JWT
                .create()
                .withSubject(String.valueOf(id))
                .withClaim("email", email)
                .withClaim("roles", roles)
                .withExpiresAt(Instant.now().plus(Duration.of(1,
                        ChronoUnit.DAYS)))
                .sign(Algorithm.HMAC256(properties.getSecretKey())); // proper set secret key
    }
}
