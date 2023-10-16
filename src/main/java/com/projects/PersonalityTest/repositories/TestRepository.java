package com.projects.PersonalityTest.repositories;

import com.projects.PersonalityTest.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
    Test findByName(String name);
}
