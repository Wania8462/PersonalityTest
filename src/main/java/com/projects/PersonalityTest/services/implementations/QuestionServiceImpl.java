package com.projects.PersonalityTest.services.implementations;

import com.projects.PersonalityTest.models.Question;
import com.projects.PersonalityTest.repositories.QuestionRepository;
import com.projects.PersonalityTest.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public Question save(Question question, Long test_id) throws Exception {
        Question newQuestion = new Question(
                question.getQuestionText(),
                question.getPosition(),
                question.getAnswers()
        );

        return questionRepository.save(newQuestion);
    }

    @Override
    public Question update(Long id, Question question, Long test_id) throws Exception {
        Question updatedQuestion = getById(id);
        updatedQuestion.setQuestionText(question.getQuestionText());
        updatedQuestion.setPosition(question.getPosition());
        updatedQuestion.setAnswers(question.getAnswers());

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
