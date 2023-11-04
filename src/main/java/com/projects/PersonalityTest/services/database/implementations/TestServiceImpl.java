package com.projects.PersonalityTest.services.database.implementations;

import com.projects.PersonalityTest.models.Question;
import com.projects.PersonalityTest.models.Test;
import com.projects.PersonalityTest.repositories.TestRepository;
import com.projects.PersonalityTest.services.database.QuestionService;
import com.projects.PersonalityTest.services.database.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;
    private final QuestionService questionService;

    @Autowired
    public TestServiceImpl(TestRepository testRepository, QuestionService questionService) {
        this.testRepository = testRepository;
        this.questionService = questionService;
    }

    @Override
    public Test save(Test test, List<Long> questionIds) throws Exception {
        List<Question> questions = new ArrayList<>();

        for(Long id : questionIds)
            questions.add(questionService.getById(id));

        Test newTest = new Test(
                test.getName(),
                questions
        );

        return testRepository.save(newTest);
    }

    @Override
    public Test update(Test test, List<Long> questionIds) throws Exception {
        List<Question> questions = new ArrayList<>();

        for(Long id : questionIds)
            questions.add(questionService.getById(id));

        Test updatedTest = getById(test.getId());
        updatedTest.setName(test.getName());
        updatedTest.setQuestions(questions);

        return testRepository.save(updatedTest);
    }

    @Override
    public Test getById(Long id) throws Exception {
        return testRepository.findById(id).orElseThrow(()-> {
            return new Exception("No value present in Optional object. Type = Test");
        });
    }

    @Override
    public Test getByName(String name) {
        return testRepository.findByName(name);
    }

    @Override
    public List<Test> getAll() {
        return testRepository.findAll();
    }

    @Override
    public boolean deleteById(Long id) {
        testRepository.deleteById(id);

        try {
            getById(id);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
