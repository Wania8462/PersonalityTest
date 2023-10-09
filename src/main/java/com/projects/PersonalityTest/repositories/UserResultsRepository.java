package com.projects.PersonalityTest.repositories;

import com.projects.PersonalityTest.models.UserResults;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserResultsRepository extends JpaRepository<UserResults, Long> {
}
