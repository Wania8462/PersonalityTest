package com.projects.PersonalityTest.services;

import com.projects.PersonalityTest.dto.TestDTO;
import com.projects.PersonalityTest.models.Test;

import java.util.List;

public interface TestService {
    Test save(Test test);
    Test create(TestDTO testDTO);
    Test getById(Long id);
    List<Test> getAll();
    void deleteById(Long id);
}
