package com.jwt.practice.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter @Setter
@Configuration
@ConfigurationProperties("security.jwt")
public class JwtProperties {
    /**
     * JwtProperties used to fetch secretKey value from
     * configuration file for Jwt token
     */
    private String secretKey;
}
