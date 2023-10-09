package com.projects.PersonalityTest.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Entity
@Data
@NoArgsConstructor
public class UserResults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int openness;
    private int painstakingness;
    private int extroversion;
    private int accommodation;
    private int neuroticism;

    @OneToOne(mappedBy = "results")
    private User user;

    public UserResults(int openness, int painstakingness, int extroversion, int accommodation, int neuroticism, User user) {
        this.openness = openness;
        this.painstakingness = painstakingness;
        this.extroversion = extroversion;
        this.accommodation = accommodation;
        this.neuroticism = neuroticism;
        this.user = user;
    }
}
