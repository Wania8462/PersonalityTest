package com.projects.PersonalityTest.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String questionText;
    private int position;
    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    public Question(String questionText, int position, List<Answer> answers) {
        this.questionText = questionText;
        this.position = position;
        this.answers = answers;
    }
}