package com.projects.PersonalityTest.services;

import com.projects.PersonalityTest.dto.QuestionDTO;
import com.projects.PersonalityTest.dto.request.QuestionRequest;
import com.projects.PersonalityTest.models.Question;

import java.util.List;

public interface QuestionService {
    Question save(Question question);
    Question save(QuestionRequest questionRequest);
    Question getById(Long id);
    List<Question> getAll();
    void deleteById(Long id);
}
