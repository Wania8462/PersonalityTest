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
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
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
