package com.projects.PersonalityTest.repositories;

import com.projects.PersonalityTest.models.Answer;
import com.projects.PersonalityTest.models.Question;
import com.projects.PersonalityTest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Optional<List<Answer>> findByUser_id(Long user_id);
    Optional<List<Answer>> findByQuestion_id(Long question_id);
}
