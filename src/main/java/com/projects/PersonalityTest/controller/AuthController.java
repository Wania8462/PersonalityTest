package com.projects.PersonalityTest.controller;

import com.projects.PersonalityTest.dto.UserDTO;
import com.projects.PersonalityTest.models.User;
import com.projects.PersonalityTest.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody UserDTO userDTO) {
        return userService.create(userDTO);
    }
}
