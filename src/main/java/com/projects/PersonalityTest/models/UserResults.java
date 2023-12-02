package com.projects.PersonalityTest.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserResults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "results")
    private User user;

    private float openness;
    private float painstakingness;
    private float extroversion;
    private float accommodation;
    private float neuroticism;

    public UserResults(User user, float openness, float painstakingness, float extroversion, float accommodation, float neuroticism) {
        this.user = user;
        this.openness = openness;
        this.painstakingness = painstakingness;
        this.extroversion = extroversion;
        this.accommodation = accommodation;
        this.neuroticism = neuroticism;
    }
}
