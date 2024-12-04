package com.jwt.practice.services.impls;

import com.jwt.practice.models.payload.requests.LoginRequest;
import com.jwt.practice.models.payload.responses.LoginResponse;
import com.jwt.practice.security.JwtIssuer;
import com.jwt.practice.security.UserPrincipal;
import com.jwt.practice.services.abstracts.AuthServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
@RequiredArgsConstructor
@Log4j2
public class AuthServicesImpl implements AuthServices {

    private final JwtIssuer jwtIssuer;
    private final AuthenticationManager authenticationManager;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        // Setting authentication into SecurityContext
        SecurityContextHolder.getContext()
                .setAuthentication(authentication);
        // Getting my UserPrincipal
        var principal = (UserPrincipal) authentication.getPrincipal();

        // Mapping roles of user.
        // Since it is returning GrantedAuthorities (interface)
        // in here we are working with List<String> for roles
        // in the actual apps we'll be working with Role models
        var roles = principal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        var token = jwtIssuer.issuer(principal.getId(),
                principal.getEmail(),
                roles);
        log.info("token: " + token);
        return LoginResponse.builder().token(token).build();
    }
}
