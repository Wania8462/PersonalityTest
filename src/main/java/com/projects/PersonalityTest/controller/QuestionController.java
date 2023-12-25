package com.projects.PersonalityTest.controller;

import com.projects.PersonalityTest.dto.QuestionDTO;
import com.projects.PersonalityTest.dto.request.QuestionRequest;
import com.projects.PersonalityTest.models.Question;
import com.projects.PersonalityTest.services.QuestionService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {
    private static QuestionService questionService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<QuestionDTO> create(@RequestBody QuestionRequest questionRequest) {
        return new ResponseEntity<>(
                map(questionService.create(questionRequest)),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionDTO> getById(@PathVariable Long id) {
        return new ResponseEntity<>(
                map(questionService.getById(id)),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<List<QuestionDTO>> getAll() {
        return new ResponseEntity<>(
                mapList(questionService.getAll()),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        questionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    private QuestionDTO map(Question question) {
        return modelMapper.map(question, QuestionDTO.class);
    }

    private List<QuestionDTO> mapList(List<Question> questions) {
        return questions.stream().map(this::map).toList();
    }
}