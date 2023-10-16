package com.projects.PersonalityTest.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "test")
    private List<Question> questions;

    public Test(String name, List<Question> questions) {
        this.name = name;
        this.questions = questions;
    }
}
