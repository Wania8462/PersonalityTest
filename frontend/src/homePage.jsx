import React from "react";
import logo from "./images/logo.png";

function HomePage() { 
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
                <button className="test-button" onClick={() => console.log("test")
                }>Пройти тест</button>
            </div>
        </div>
    );
}

export default HomePage;