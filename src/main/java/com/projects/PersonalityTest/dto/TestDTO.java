package com.projects.PersonalityTest.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TestDTO {
    private Long id;
    private String name;
    private List<QuestionDTO> questions;
}
