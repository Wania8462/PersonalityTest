using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PersonalityTest.Frontend.Models
{
    public class Question
    {
        public Question(int id, string text)
        {
            Id = id;
            Text = text;
        }
        
        public int Id { get; set;}

        public string Text { get; set; }
    }
}