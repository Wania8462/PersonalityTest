package com.projects.PersonalityTest.services.database;

import com.projects.PersonalityTest.models.User;
import com.projects.PersonalityTest.models.UserResults;

import java.util.List;

public interface UserResultsService {
    UserResults save(UserResults results, Long userId) throws Exception;
    UserResults update(UserResults results, Long userId) throws Exception;
    public UserResults getById(Long userId) throws Exception;
    List<UserResults> getAll();
    boolean deleteById(Long id);
}
