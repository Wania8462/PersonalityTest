using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PersonalityTest.Frontend.Models
{
    public class Questionnaire
    {
        public Questionnaire(string name,  IList<Question> questions)
        {
            Name = name;
            Questions = questions;
        }

        public string Name { get;}
        public IList<Question> Questions { get; }
    }
}