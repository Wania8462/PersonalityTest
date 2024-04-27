using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PersonalityTest.Frontend.Models
{
    public class Question
    {
        public Question(int id, string text, string group, bool invertedScore)
        {
            Id = id;
            Text = text;
            Group = group;
            InvertedScore = invertedScore;
        }
        
        public int Id { get; set;}
        public string Text { get; set; }
        public string Group { get; set; }
        public bool InvertedScore { get; set; }
    }
}