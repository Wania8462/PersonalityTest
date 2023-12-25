package com.projects.PersonalityTest.dto.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class QuestionRequest {
    private Long id;
    private String questionText;
    private int position;
}
