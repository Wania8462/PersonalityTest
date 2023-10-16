package com.projects.PersonalityTest.services;

import com.projects.PersonalityTest.models.Question;
import com.projects.PersonalityTest.models.Test;
import com.projects.PersonalityTest.models.User;
import com.projects.PersonalityTest.models.UserResults;

import java.util.List;

public interface QuestionService {
    Question save(Question question, Long test_id) throws Exception;
    Question update(Question question, Long test_id) throws Exception;
    Question getById(Long id) throws Exception;
    List<Question> getAll();
    boolean deleteById(Long id);
}
