package com.jwt.practice.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */

@Component
public class JwtToPrincipalConverter {

    public UserPrincipal convert(DecodedJWT decodedJWT) {
        return UserPrincipal.builder()
                .id(Long.valueOf(decodedJWT.getSubject()))
                .email(decodedJWT.getClaim("email").asString())
                .authorities(extractAuthoritiesFromClaim(decodedJWT))
                .build();
    }

    private List<SimpleGrantedAuthority> extractAuthoritiesFromClaim(DecodedJWT decodedJWT) {
        var claim = decodedJWT.getClaim("roles");
        if (claim.isNull() || claim.isMissing()) return List.of();
        return claim.asList(SimpleGrantedAuthority.class);
    }
}
