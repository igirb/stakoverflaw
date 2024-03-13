import {useEffect, useState} from "react";

const Questions = () => {
    const [displayQuestions, setDisplayQuestions] = useState([]);
    const [sortedQuestions, setSortedQuestion] = useState([]);
    const [showSorted, setShowSorted] = useState(false);

    useEffect(() => {
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
        },
        []);
    const handleDelete = (id) => {
        fetch(`/api/question/${id}`, {
            method: 'DELETE'
        })
            .then(() => {
                setDisplayQuestions(prevQuestions => prevQuestions.filter(todo => todo._id !== id));
                window.location.reload();
            })
            .catch(error => console.error(error));
    }

    const handleShowAnswers = () => {
        console.log("from handleShowAnswers")
    };
    const handleSort = (title) => {
        fetch(`/api/question/sorted/${title}`)
            .then((response) => {
                return response.json();
            })
            .then((response) => {
                setSortedQuestion(response);
                setShowSorted(!showSorted);
            })
            .catch((error) => {
                console.error(error);
            });
    };

    return (
        <div className="questions">
            <button onClick={() => handleSort("title")}>Sort by title</button>
            <button onClick={() => handleSort("date")}>Latest Questions</button>
            {showSorted ? (
                <div>
                    {sortedQuestions.map((question, index) => (
                        <div key={index}>
                            <h3>Title: {question.title}</h3>
                            <text>Question: {question.description}</text>
                            <button onClick={() => handleDelete(question.id)}>Delete</button>
                            <button onClick={handleShowAnswers}>Show answers</button>
                        </div>
                    ))}
                </div>
            ) : (
                <div>
                    {displayQuestions.map((question, index) => (
                        <div key={index}>
                            <h3>Title: {question.title}</h3>
                            <h5>Question: {question.description}</h5>

                            <button onClick={() => handleDelete(question.id)}>Delete</button>
                            <button onClick={handleShowAnswers}>Show answers</button>
                        </div>
                    ))}
                </div>
            )}
        </div>
    );
};

export default Questions;