package com.projects.PersonalityTest.models;

import com.projects.PersonalityTest.models.enums.ERole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false, unique = true)
    @Email(message = "Email is incorrect")
    private String email;

    @Column(nullable = false, length = 13)
    private String phone;

    private ERole roles;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "result_id", referencedColumnName = "id")
    private UserResults results;

    @OneToMany(mappedBy = "user")
    private List<Answer> answer;

    public User(String firstname, String lastName, String email, String phone) {
        this.firstname = firstname;
        this.lastname = lastName;
        this.email = email;
        this.phone = phone;
    }

    public User(String firstname, String lastName, String email, String phone, UserResults results) {
        this.firstname = firstname;
        this.lastname = lastName;
        this.email = email;
        this.phone = phone;
        this.results = results;
    }
}
