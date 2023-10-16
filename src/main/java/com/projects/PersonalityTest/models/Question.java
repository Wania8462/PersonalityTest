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

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private Test test;

    public Question(String questionText, int position, List<Answer> answers, Test test) {
        this.questionText = questionText;
        this.position = position;
        this.answers = answers;
        this.test = test;
    }
}