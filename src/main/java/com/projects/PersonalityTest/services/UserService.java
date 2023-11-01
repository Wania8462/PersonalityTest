package com.projects.PersonalityTest.services;

import com.projects.PersonalityTest.models.User;
import com.projects.PersonalityTest.models.UserResults;

import java.util.List;

public interface UserService {
    User save(User user);
    User update(Long id, User user, Long resultsId) throws Exception;

    User getById(Long id) throws Exception;
    User getByFirstname(String firstname);
    User getByLastname(String lastname);
    User getByEmail(String email);
    User getByPhone(int phone);

    List<User> getAll();
    boolean deleteById(Long id);
}
