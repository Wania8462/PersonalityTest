package com.projects.PersonalityTest.services;

import com.projects.PersonalityTest.models.User;
import com.projects.PersonalityTest.models.UserResults;

import java.util.List;

public interface UserResultsService {
    UserResults save(UserResults results, Long userId) throws Exception;
    UserResults update(UserResults results, User user) throws Exception;
    UserResults getById(Long id) throws Exception;
    UserResults getByUser(User user);
    List<UserResults> getAll();
    boolean deleteById(Long id);
}
