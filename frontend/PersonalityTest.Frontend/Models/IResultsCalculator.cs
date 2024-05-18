namespace PersonalityTest.Frontend.Models
{
    public interface IResultsCalculator
    {
        QuestionniareResults CalculateResults(QuestionnareAnswers answers, Questionnaire questionnaire);
    }
}