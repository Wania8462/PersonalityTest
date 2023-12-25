package com.projects.PersonalityTest.services.implementations;

import com.projects.PersonalityTest.exception.AnswerNotFoundException;
import com.projects.PersonalityTest.models.Answer;
import com.projects.PersonalityTest.models.Question;
import com.projects.PersonalityTest.models.User;
import com.projects.PersonalityTest.repositories.AnswerRepository;
import com.projects.PersonalityTest.services.AnswerService;
import com.projects.PersonalityTest.services.QuestionService;
import com.projects.PersonalityTest.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final UserService userService;
    private final QuestionService questionService;

    @Override
    public Answer save(Answer answer, Long user_id, Long question_id) {
        User user = userService.getById(user_id);
        Question question = questionService.getById(question_id);

        Answer newAnswer = Answer.builder()
                .answer(answer.getAnswer())
                .user(user)
                .question(question)
                .build();

        return answerRepository.save(newAnswer);
    }

    @Override
    public Answer update(Long id, int answer) {
        Answer updatedAnswer = getById(id);
        updatedAnswer.setAnswer(answer);

        return answerRepository.save(updatedAnswer);
    }

    @Override
    public Answer getById(Long id) {
        return answerRepository.findById(id).orElseThrow(
                () -> new AnswerNotFoundException("Answer not found by id: " + id)
        );
    }

    @Override
    public List<Answer> getByUser(Long user_id) {
        return answerRepository.findByUser_id(user_id).orElseThrow(
                () -> new AnswerNotFoundException("No answers found for user with id: " + user_id)
        );
    }

    @Override
    public List<Answer> getByQuestion(Long question_id) {
        return answerRepository.findByQuestion_id(question_id).orElseThrow(
                () -> new AnswerNotFoundException("No answers found for question with id: " + question_id)
        );
    }

    @Override
    public void deleteById(Long id) {
        answerRepository.deleteById(id);
    }
}
