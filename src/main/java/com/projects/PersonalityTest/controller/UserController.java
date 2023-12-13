package com.projects.PersonalityTest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projects.PersonalityTest.dto.UserDTO;
import com.projects.PersonalityTest.models.User;
import com.projects.PersonalityTest.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody UserDTO userDTO) {
        return userService.create(userDTO);
    }
}
