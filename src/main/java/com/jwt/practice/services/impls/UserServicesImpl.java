package com.jwt.practice.services.impls;

import com.jwt.practice.models.entities.User;
import com.jwt.practice.models.payload.requests.UserRequest;
import com.jwt.practice.repositories.UserRepository;
import com.jwt.practice.security.UserPrincipal;
import com.jwt.practice.services.abstracts.UserServices;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserServices {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    @Override
    public String save(UserRequest userRequest) {
        User user = User.builder()
                .fullName(userRequest.getFullName())
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .build();
        if (userRepository.count() > 2) {
            user.setRole("ROLE_ADMIN");
        } else {
            user.setRole("ROLE_USER");
        }
        userRepository.save(user);
        return "User saved, you can login now.";
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow();
    }
}
