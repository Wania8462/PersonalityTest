package com.projects.PersonalityTest.controller;

import com.projects.PersonalityTest.dto.TestDTO;
import com.projects.PersonalityTest.models.Test;
import com.projects.PersonalityTest.services.TestService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/test")
public class TestController {
//    private final TestService testService;
//    private final ModelMapper modelMapper;
//
//    @PostMapping
//    public ResponseEntity<TestDTO> create(@RequestBody TestDTO testDTO) {
//        Test test = testService.save();
//
//        return new ResponseEntity<>(
//                map(questionService.save(questionRequest)),
//                HttpStatus.CREATED
//        );
//    }
//
//    public TestDTO map(Test test) {
//        return modelMapper.map(test, TestDTO.class);
//    }
}
