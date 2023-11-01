package com.projects.PersonalityTest.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    @Email(message = "Email is incorrect")
    private String email;

    @Column(nullable = false, length = 13)
    private int phone;

    @OneToOne(mappedBy = "user")
    private UserResults results;

    @OneToMany(mappedBy = "user")
    private List<Answer> answer;

    public User(String firstname, String lastName, String email, int phone) {
        this.firstname = firstname;
        this.lastname = lastName;
        this.email = email;
        this.phone = phone;
    }

    public User(String firstname, String lastName, String email, int phone, UserResults results) {
        this.firstname = firstname;
        this.lastname = lastName;
        this.email = email;
        this.phone = phone;
        this.results = results;
    }
}
