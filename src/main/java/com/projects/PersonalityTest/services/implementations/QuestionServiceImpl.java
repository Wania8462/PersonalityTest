package com.projects.PersonalityTest.services.implementations;

import com.projects.PersonalityTest.dto.QuestionDTO;
import com.projects.PersonalityTest.dto.request.QuestionRequest;
import com.projects.PersonalityTest.exception.QuestionNotFoundException;
import com.projects.PersonalityTest.models.Question;
import com.projects.PersonalityTest.repositories.QuestionRepository;
import com.projects.PersonalityTest.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question save(QuestionRequest questionRequest) {
        Question question = Question.builder()
                .questionText(questionRequest.getQuestionText())
                .answers(new ArrayList<>())
                .build();

        return questionRepository.save(question);
    }

    @Override
    public Question getById(Long id) {
        return questionRepository.findById(id).orElseThrow(
                () -> new QuestionNotFoundException("Question bot found by id: " + id)
        );
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        questionRepository.deleteById(id);
    }
}
