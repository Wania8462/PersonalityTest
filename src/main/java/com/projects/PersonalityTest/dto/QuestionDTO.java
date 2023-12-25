package com.projects.PersonalityTest.dto;

import com.projects.PersonalityTest.models.Answer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class QuestionDTO {
    private Long id;
    private String questionText;
    private int position;
    private List<Answer> answers;
}
