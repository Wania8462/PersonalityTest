package com.projects.PersonalityTest.repositories;

import com.projects.PersonalityTest.models.Answer;
import com.projects.PersonalityTest.models.Question;
import com.projects.PersonalityTest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByUser(User user);
    List<Answer> findByQuestion(Question question);
}
