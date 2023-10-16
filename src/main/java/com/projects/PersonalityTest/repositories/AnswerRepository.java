package com.projects.PersonalityTest.repositories;

import com.projects.PersonalityTest.models.Answer;
import com.projects.PersonalityTest.models.Question;
import com.projects.PersonalityTest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByUser(User user);
    List<Answer> findByQuestion(Question question);
}
