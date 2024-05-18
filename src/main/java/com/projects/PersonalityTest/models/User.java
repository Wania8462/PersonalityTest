package com.projects.PersonalityTest.models;

import com.projects.PersonalityTest.models.enums.ERole;
import jakarta.persistence.*;
//import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column( unique = true)
    private String coachEmail;

    private ERole roles;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "result_id", referencedColumnName = "id")
    private UserResults results;

    @OneToMany(mappedBy = "user")
    private List<Answer> answer;

    public User(String firstname, String lastName, String email) {
        this.firstname = firstname;
        this.lastname = lastName;
        this.email = email;
    }

    public User(String firstname, String lastName, String email, String coachEmail) {
        this.firstname = firstname;
        this.lastname = lastName;
        this.email = email;
        this.coachEmail = coachEmail;
    }

    public User(String firstname, String lastName, String email, UserResults results) {
        this.firstname = firstname;
        this.lastname = lastName;
        this.email = email;
        this.results = results;
    }

    public User(String firstname, String lastName, String email, String coachEmail, UserResults results) {
        this.firstname = firstname;
        this.lastname = lastName;
        this.email = email;
        this.coachEmail = coachEmail;
        this.results = results;
    }
}