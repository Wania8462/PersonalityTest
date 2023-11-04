package com.projects.PersonalityTest.services.database.implementations;

import com.projects.PersonalityTest.models.Question;
import com.projects.PersonalityTest.repositories.QuestionRepository;
import com.projects.PersonalityTest.services.database.QuestionService;
import com.projects.PersonalityTest.services.database.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final TestService testService;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository, TestService testService) {
        this.questionRepository = questionRepository;
        this.testService = testService;
    }

    @Override
    public Question save(Question question, Long test_id) throws Exception {
        Question newQuestion = new Question(
                question.getQuestionText(),
                question.getPosition(),
                question.getAnswers(),
                testService.getById(test_id)
        );

        return questionRepository.save(newQuestion);
    }

    @Override
    public Question update(Long id, Question question, Long test_id) throws Exception {
        Question updatedQuestion = getById(id);
        updatedQuestion.setQuestionText(question.getQuestionText());
        updatedQuestion.setPosition(question.getPosition());
        updatedQuestion.setAnswers(question.getAnswers());
        updatedQuestion.setTest(testService.getById(test_id));

        return questionRepository.save(updatedQuestion);
    }

    @Override
    public Question getById(Long id) throws Exception {
        return questionRepository.findById(id).orElseThrow(()-> {
            return new Exception("No value present in Optional object. Type = Question");
        });
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public boolean deleteById(Long id) {
        questionRepository.deleteById(id);

        try {
            getById(id);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
