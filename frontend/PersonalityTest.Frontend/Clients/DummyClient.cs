using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using PersonalityTest.Frontend.Models;

namespace PersonalityTest.Frontend.Clients
{
    public class DummyClient : IClient
    {
        public DummyClient() { }

        public async Task<Questionnaire> GetQuestionnaire(string name)
        {
            var questions = new List<Question>() {
                new(1, "Я вижу красоту и смыслы там, где другие их не видят", "O", false),
                new(2, "Если человек мне не нравится, я не восприму его аргументы впринципе", "O", true),
                new(3, "Я ценю чистоту и порядок по всем", "P", false),
                new(4, "Я редко читаю что-либо о самоорганизации и менеджменте времени", "P", true),
                new(5, "Мне нравится чувствовать адреналин", "E", false),
                new(6, "Я довольно быстро и громко говорю", "E", false),
                new(7, "Я могу пожертвовать своими интересами и временем ради других", "A", false),
                new(8, "Мне неспокойно, когда другие чувствуют себя плохо  ", "A", false),
                new(9, "Я часто прокручиваю в голове слова людей, которые меня задели", "N", false),
                new(10, "Я часто представляю худший сценарий ", "N", false),
            };
            return new Questionnaire(name, questions);
        }

        public async Task SaveAnswers(QuestionnareAnswers answers) {

        }
    }
}