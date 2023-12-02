import { useEffect, useState } from "react";
import ReactDOM from "react-dom";

import logo from './images/logo.png';

import "./App.css";
import Register from "./register";

function App() {
    const root = ReactDOM.createRoot(document.getElementById('root'));

    return (
        <div>
            <div className="menu">
                <img
                    className="logo"
                    src={logo}
                />
                <p className="white p">
                    Академия Экспоненциального Коучинга представляет тест личности «5 голосов»
                </p>
            </div>

            <div className="test-button-holder">
                <button className="test-button" onClick={() => 
                    ReactDOM.render(<Register/>, document.getElementById("root"))
                }>Пройти тест</button>
            </div>
        </div>
    );
}

export default App;