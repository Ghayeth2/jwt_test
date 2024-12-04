package com.jwt.practice.services.abstracts;


import com.jwt.practice.models.entities.User;
import com.jwt.practice.models.payload.requests.UserRequest;

public interface UserServices {
    // Just for this example, no Dtos requests other than Login

    /**
     *
     * @param userRequest
     * @return
     */
    String save(UserRequest userRequest);

    /**
     *
     * @param email
     * @return
     */
    User findByEmail(String email);
}
