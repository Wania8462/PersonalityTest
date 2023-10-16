package com.projects.PersonalityTest.repositories;

import com.projects.PersonalityTest.models.Question;
import com.projects.PersonalityTest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
