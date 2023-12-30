import React, { useState } from 'react';

function Question() {

    const [questionNumber, setQuestionNumber] = useState(1);

    return (
        <div className='registration-form'>
            <h3>{questionNumber}. </h3>
        </div>
    );
}

export default Question;