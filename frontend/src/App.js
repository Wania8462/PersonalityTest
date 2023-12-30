import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HomePage from './homePage';
import Question from './question';
import Register from './register'

function App() {
    return (
        <Router>
            <Routes>
                <Route exact path='/' component={HomePage} />
                <Route exact path='/question' component={Question} />
                <Route exact path='/register' component={Register} />
            </Routes>
        </Router>
    );
}

export default App;