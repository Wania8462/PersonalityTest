package com.projects.PersonalityTest.repositories;

import com.projects.PersonalityTest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByFirstname(String firstname);
    List<User> findAllByLastname(String lastname);
    Optional<User> findByEmail(String email);
}
