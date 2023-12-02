package com.projects.PersonalityTest.services;

import com.projects.PersonalityTest.models.Answer;

import java.util.List;

public interface AnswerService {
    Answer save(Answer answer, Long user_id, Long question_id) throws Exception;
    Answer update(Long id, int answer) throws Exception;
    Answer getById(Long id) throws Exception;
    List<Answer> getByUser(Long user_id) throws Exception;
    List<Answer> getByQuestion(Long question_id) throws Exception;
    List<Answer> getAll();
    boolean deleteById(Long id) throws Exception;
}
