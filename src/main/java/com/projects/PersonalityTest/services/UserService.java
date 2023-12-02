package com.projects.PersonalityTest.services;

import com.projects.PersonalityTest.dto.UserDTO;
import com.projects.PersonalityTest.models.User;

import java.util.List;

public interface UserService {
    User save(User user);
    User create(UserDTO userDTO);
    User update(Long id, UserDTO userDTO);

    User getById(Long id);
    User getByEmail(String email);
    List<User> getByFirstname(String firstname);
    List<User> getByLastname(String lastname);

    List<User> getAll();
    void delete(Long id);
}
