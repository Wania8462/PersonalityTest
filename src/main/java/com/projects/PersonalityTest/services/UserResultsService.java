package com.projects.PersonalityTest.services;

import com.projects.PersonalityTest.dto.UserResultsDTO;
import com.projects.PersonalityTest.models.User;
import com.projects.PersonalityTest.models.UserResults;

import java.util.List;

public interface UserResultsService {
    UserResults save(UserResults results);
    UserResults create(UserResultsDTO ResultsDTO);
    UserResults update(UserResultsDTO resultsDTO, Long id);
    public UserResults getById(Long userId);
    List<UserResults> getAll();
    void delete(Long id);
}
