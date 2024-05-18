namespace PersonalityTest.Frontend.Models
{
    public class QuestionnareAnswers
    {
        public QuestionnareAnswers(Questionnaire questionnaire)
        {
            Questionnaire = questionnaire;
            Answers = new Dictionary<int, AnswerOptions>();
        }
        public Questionnaire Questionnaire { get; private set; }

        public IDictionary<int,AnswerOptions> Answers { get; private set; }
    }
}