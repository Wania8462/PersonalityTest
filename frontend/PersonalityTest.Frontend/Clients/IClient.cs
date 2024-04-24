using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using PersonalityTest.Frontend.Models;

namespace PersonalityTest.Frontend.Clients
{
    public interface IClient
    {
        public Task<Questionnaire> GetQuestionnaire(string name);

        public Task SaveAnswers(QuestionnareAnswers answers);
    }
}