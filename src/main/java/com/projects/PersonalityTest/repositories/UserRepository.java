package com.projects.PersonalityTest.repositories;

import com.projects.PersonalityTest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByFirstname(String firstname); // Exceptions
    User findByLastname(String lastname);
    User findByEmail(String email);
    User findByPhone(int phone);
}
