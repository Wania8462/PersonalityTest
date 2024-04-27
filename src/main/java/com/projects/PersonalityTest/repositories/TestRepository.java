package com.projects.PersonalityTest.repositories;

import com.projects.PersonalityTest.models.Question;
import com.projects.PersonalityTest.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
}
