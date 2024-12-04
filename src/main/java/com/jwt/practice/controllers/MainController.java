package com.jwt.practice.controllers;

import com.jwt.practice.models.entities.User;
import com.jwt.practice.repositories.UserRepository;
import com.jwt.practice.security.UserPrincipal;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

/**
 * MainController of the API to render and handle general requests
 * such as (greetings).
 */
@RestController
@RequestMapping("/api")
// RequiredArgsConstructor injects all field
// signed as final field only.
@RequiredArgsConstructor
public class MainController {

    private final UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<List<User>> users(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/greetings")
    public String greetings(@AuthenticationPrincipal UserPrincipal principal) {
        return "Hello "+principal.getId()+
                " your email: "+principal.getEmail();
    }
}
