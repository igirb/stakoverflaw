import { useState } from "react";

const Questions = () => {
    const [displayQuestions, setDisplayQuestions] = useState([]);
    const [showQuestions, setShowQuestions] = useState(false);

    const handleClick = () => {
        setShowQuestions(!showQuestions);
        if (!showQuestions) {
            fetch("/api/question/all")
                .then((response) => {
                    return response.json();
                })
                .then((response) => {
                    setDisplayQuestions(response);
                })
                .catch((error) => {
                    console.error(error);
                });
        }
    };

    return (
        <div className="todos">
            <button onClick={handleClick}>
                {showQuestions ? "Hide questions" : "Show questions"}
            </button>
            {showQuestions && (
                <div>
                    {displayQuestions.map((question, index) => (
                        <div key={index}>
                            <h3>Title: {question.title}</h3>
                            <h5>Question: {question.comment}</h5>
                        </div>
                    ))}
                </div>
            )}
        </div>
    );
};

export default Questions;