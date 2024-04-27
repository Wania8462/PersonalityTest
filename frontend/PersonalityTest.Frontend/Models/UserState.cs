using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PersonalityTest.Frontend.Models
{
    public class UserState
    {
        public UserState(string userId)
        {
            UserId = userId;
        }
        
        public string UserId { get; private set; }
        public Questionnaire CurrentTest { get; private set; }
        public QuestionnareAnswers CurrentAnswers { get; private set; }

        private int nextQuestion = 0;
 
        public void StartTest(Questionnaire questionnaire) {
            //TODO: Randimaze questions
            CurrentTest = questionnaire;
            CurrentAnswers = new QuestionnareAnswers(CurrentTest);
            nextQuestion = 0;
        }

        public Question? GetNextQuestion() {
            if (nextQuestion == CurrentTest.Questions.Count) 
                return null;
            
            var nextQ = CurrentTest.Questions[nextQuestion];
            nextQuestion++;
            return nextQ;
        }

        public Question? SeeNextQuestion() 
        {
            if (nextQuestion == CurrentTest.Questions.Count) 
                return null;

            return CurrentTest.Questions[nextQuestion];
        }

        public void SaveAnswer(Question question, AnswerOptions userAnswer) {
            CurrentAnswers.Answers.Add(question.Id, userAnswer);
        }
    }
}