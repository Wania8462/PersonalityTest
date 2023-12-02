package com.projects.PersonalityTest.services;

import com.projects.PersonalityTest.models.Question;

import java.util.List;

public interface QuestionService {
    Question save(Question question, Long test_id) throws Exception;
    Question update(Long id, Question question, Long test_id) throws Exception;
    Question getById(Long id) throws Exception;
    List<Question> getAll();
    boolean deleteById(Long id);
}
