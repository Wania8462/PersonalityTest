package com.projects.PersonalityTest.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String lastName;
    @Column(nullable = false)
    @Email(message = "Email is incorrect")
    private String email;
    @Column(nullable = false, length = 13)
    private int phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "results_id", referencedColumnName = "id")
    private UserResults results;

    public User(String firstname, String lastName, String email, int phone, UserResults results) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.results = results;
    }

    public User(String firstname, String lastName, String email, int phone) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
}
