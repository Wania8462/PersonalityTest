package com.projects.PersonalityTest.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int answer;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id", nullable = false, updatable = false)
    private Question question;

    public Answer(int answer, User user, Question question) {
        this.answer = answer;
        this.user = user;
        this.question = question;
    }
}
