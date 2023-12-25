package com.projects.PersonalityTest.services;

import com.projects.PersonalityTest.models.Answer;

import java.util.List;

public interface AnswerService {
    Answer save(Answer answer, Long user_id, Long question_id);
    Answer update(Long id, int answer);
    Answer getById(Long id);
    List<Answer> getByUser(Long user_id);
    List<Answer> getByQuestion(Long question_id);
    void deleteById(Long id);
}
