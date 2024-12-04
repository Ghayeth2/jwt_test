package com.jwt.practice.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity @Getter @Setter
@Builder @NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    // Annotate with @IgnoreCase so that no hashes might get leaked
    @JsonIgnore
    private String password;
    private String fullName;
    // In real app it will be another mapped model
    private String role;
}
