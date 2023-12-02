package com.projects.PersonalityTest.services.implementations;

import com.projects.PersonalityTest.dto.UserDTO;
import com.projects.PersonalityTest.exception.UserNotFoundException;
import com.projects.PersonalityTest.models.User;
import com.projects.PersonalityTest.models.enums.ERole;
import com.projects.PersonalityTest.repositories.UserRepository;
import com.projects.PersonalityTest.services.UserService;
import com.projects.PersonalityTest.services.UserResultsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User create(UserDTO userDTO) {
        User user = User.builder()
                .firstname(userDTO.getFirstname())
                .lastname(userDTO.getLastname())
                .email(userDTO.getEmail())
                .phone(userDTO.getPhone())
                .roles(ERole.USER)
                .build();

        return userRepository.save(user);
    }

    @Override
    public User update(Long id, UserDTO userDTO) {
        User user = User.builder()
                .id(id)
                .firstname(userDTO.getFirstname())
                .lastname(userDTO.getLastname())
                .email(userDTO.getEmail())
                .phone(userDTO.getPhone())
                .build();

        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User not found by id: " + id)
        );
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> new UserNotFoundException("User not found by email: " + email)
        );
    }

    @Override
    public List<User> getByFirstname(String firstname) {
        return userRepository.findAllByFirstname(firstname);
    }

    @Override
    public List<User> getByLastname(String lastname) {
        return userRepository.findAllByFirstname(lastname);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        User user = getById(id);
        userRepository.delete(user);
    }
}