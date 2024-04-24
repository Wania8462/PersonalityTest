using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PersonalityTest.Frontend.Models
{
    public interface IUserSessions
    {
        UserState? GetUserState(string userId);

        UserState AddUserState(string userId);
    }
}