namespace PersonalityTest.Frontend.Models
{
    public class ResultsCalculator : IResultsCalculator
    {
        public QuestionniareResults CalculateResults(QuestionnareAnswers answers, Questionnaire questionnaire)
        {
            QuestionniareResults results = new();
            IList<Question> questions = questionnaire.Questions;
            int i = 0;

            // TODO: reduce repetition
            
            foreach (KeyValuePair<int, AnswerOptions> answer in answers.Answers)
            {
                switch(questions[i].Group)
                {
                    case "O":
                        results.openness += AddPoints(answer.Value, questions[i].InvertedScore);
                        break;

                    case "P":
                        results.painstakingness += AddPoints(answer.Value, questions[i].InvertedScore);
                        break;

                    case "E":
                        results.extroversion += AddPoints(answer.Value, questions[i].InvertedScore);
                        break;

                    case "A":
                        results.accommodation += AddPoints(answer.Value, questions[i].InvertedScore);
                        break;

                    case "N":
                        results.neuroticism += AddPoints(answer.Value, questions[i].InvertedScore);
                        break;
                }

                i++;
            }

            results.openness /= questions.Count / 5;
            results.painstakingness /= questions.Count / 5;
            results.extroversion /= questions.Count / 5;
            results.accommodation /= questions.Count / 5;
            results.neuroticism /= questions.Count / 5;
            return results;
        }

        private int AddPoints(AnswerOptions option, bool inverted)
        {
            if(!inverted)
                return (int)option;

            return option switch
            {
                AnswerOptions.StronglyNo => 5,
                AnswerOptions.MaybeNo => 4,
                AnswerOptions.Neutral => 3,
                AnswerOptions.MaybeYes => 2,
                AnswerOptions.StronglyYes => 1,
                _ => 0,
            };
        }
    }
}