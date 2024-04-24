using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PersonalityTest.Frontend.Models
{
    public class UserSessions: IUserSessions
    {
        private readonly Dictionary<string, UserState> _sessions = [];

        public UserState? GetUserState(string userId) {
            if (_sessions.ContainsKey(userId)) {return _sessions[userId];}
            return null;
        }

        public UserState AddUserState(string userId) {
            _sessions[userId] = new UserState(userId);
            return _sessions[userId];
        }
    }
}