package com.projects.PersonalityTest.services.implementations;

import com.projects.PersonalityTest.dto.QuestionDTO;
import com.projects.PersonalityTest.dto.TestDTO;
import com.projects.PersonalityTest.models.Question;
import com.projects.PersonalityTest.models.Test;
import com.projects.PersonalityTest.repositories.QuestionRepository;
import com.projects.PersonalityTest.repositories.TestRepository;
import com.projects.PersonalityTest.services.QuestionService;
import com.projects.PersonalityTest.services.TestService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;
    private final ModelMapper modelMapper;

    @Override
    public Test save(Test test) {
        return testRepository.save(test);
    }

    @Override
    public Test create(TestDTO testDTO) {
        Test newTest = Test.builder()
                .name(testDTO.getName())
                .questions(mapList(testDTO.getQuestions()))
                .build();

        return testRepository.save(newTest);
    }

    @Override
    public Test getById(Long id) {
        return testRepository.getReferenceById(id);
    }

    @Override
    public List<Test> getAll() {
        return testRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        testRepository.deleteById(id);
    }

    private Question map(QuestionDTO question) {
        return modelMapper.map(question, Question.class);
    }

    private List<Question> mapList(List<QuestionDTO> questions) {
        return questions.stream().map(this::map).toList();
    }
}
