package com.projects.PersonalityTest.services.implementations;

import com.projects.PersonalityTest.models.Answer;
import com.projects.PersonalityTest.repositories.AnswerRepository;
import com.projects.PersonalityTest.services.AnswerService;
import com.projects.PersonalityTest.services.QuestionService;
import com.projects.PersonalityTest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final UserService userService;
    private final QuestionService questionService;

    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepository, UserService userService, QuestionService questionService) {
        this.answerRepository = answerRepository;
        this.userService = userService;
        this.questionService = questionService;
    }

    @Override
    public Answer save(Answer answer, Long user_id, Long question_id) throws Exception {
        Answer newAnswer = new Answer(
                answer.getAnswer(),
                userService.getById(user_id),
                questionService.getById(question_id)
        );

        return answerRepository.save(newAnswer);
    }

    @Override
    public Answer update(Long id, int answer) throws Exception {
        Answer updatedAnswer = getById(id);
        updatedAnswer.setAnswer(answer);

        return answerRepository.save(updatedAnswer);
    }

    @Override
    public Answer getById(Long id) throws Exception {
        return answerRepository.findById(id).orElseThrow(()-> {
            return new Exception("No value present in Optional object. Type = Answer");
        });
    }

    @Override
    public List<Answer> getByUser(Long user_id) throws Exception {
        return answerRepository.findByUser(userService.getById(user_id));
    }

    @Override
    public List<Answer> getByQuestion(Long question_id) throws Exception {
        return answerRepository.findByQuestion(questionService.getById(question_id));
    }

    @Override
    public List<Answer> getAll() {
        return answerRepository.findAll();
    }

    @Override
    public boolean deleteById(Long id) throws Exception {
        answerRepository.deleteById(id);

        try {
            getById(id);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
