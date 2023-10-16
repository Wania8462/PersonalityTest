package com.projects.PersonalityTest.services;

import com.projects.PersonalityTest.models.Question;
import com.projects.PersonalityTest.models.Test;


import java.util.List;

public interface TestService {
    Test save(Test test, List<Long> questionIds) throws Exception;
    Test update(Test test, List<Long> questionIds) throws Exception;
    Test getById(Long id) throws Exception;
    Test getByName(String name);
    List<Test> getAll();
    boolean deleteById(Long id);
}
