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
                new(1, " Мне нравиться заниматься физкультурой"),
                new(2, " Люди считают меня отзывчивым и доброжелательным человеком"),
                new(3, "Я во всем ценю чистоту и порядок"),
                new(4, "Меня часто беспокоит мысль, что что-нибудь может случиться"),
                new(5, "Все новое вызывает у меня интерес"),
                new(6, "Если я ничем не занят, то это меня беспокоит"),
                new(7, "Я стараюсь проявлять дружелюбие ко всем людям"),
                new(8, "Моя комната всегда аккуратно прибрана"),
                new(9, "Иногда я расстраиваюсь из-за пустяков"),
                new(10, "Мне нравятся неожиданности"),
                new(11, "Я не могу долго оставаться в неподвижности"),
                new(12, "Я тактичен по отношения к другим людям"),
                new(13, "Я методичен и пунктуален во всем"),
                new(14, "Мои чувства легко уязвимы и ранимы"),

            };
            return new Questionnaire(name, questions);
        }

        public async Task SaveAnswers(QuestionnareAnswers answers) {

        }
    }
}