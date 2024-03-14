import {useEffect, useState} from "react"
import Answer from "./Answer";
import {useParams} from "react-router-dom";
import {Link} from "react-router-dom";

const fetchAnswers = async (questionId) => {
    const response = await fetch(`/api/answer/question/${questionId}`);
    if (response.ok) {
        const data = await response.json();
        console.log(data)
        return data;
    } else {
        throw new Error("Failed to fetch answers");
    }
}

const fetchQuestionById = async (questionId) => {
    const response = await fetch(`/api/question/${questionId}`);
    if (response.ok) {
        const data = await response.json();
        return data;
    } else {
        throw new Error("Failed to fetch question");
    }
}

const Answers = () => {
    const [answers, setAnswers] = useState(null);
    const [isLoading, setIsLoading] = useState(true);
    const {questionId} = useParams();
    const [message, setMessage] = useState("");
    const [question, setQuestion] = useState(null);
    console.log(questionId)

    useEffect(() => {
        fetchAnswers(questionId)
            .then(data => {
                setAnswers(data);
            })
            .then(() => fetchQuestionById(questionId))
            .then(data => {
                setQuestion(data);
                setIsLoading(false);
            })
    }, []);

    function handleSubmit() {
        const data = {message, questionId};
        fetch('/api/answer/', {

            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        })
            .then((response) => response.json())
            .then((response) => {
                console.log(response);
                window.location.reload();
            })
            .catch((err) => {
                console.error(err);
            });
    }

    const handleDelete = (id) => {
        fetch(`/api/answer/${id}`, {
            method: 'DELETE'
        })
            .then(() => {
                setAnswers(prevAnswers => prevAnswers.filter(answer => answer.questionId !== questionId));
                window.location.reload();
            })
            .catch(error => {
                console.error('Error deleting answer:', error);
            })
    }

    return <div>
        <div style={{position: "fixed", top: "10px", left: "10px"}}>
            <Link to={`/`}>
                <button type="button">Back</button>
            </Link>
        </div>
        {!isLoading && <div style={{backgroundColor: '#3498db', // Blue background color
            borderRadius: '10px', // Rounded corners
            border: '2px solid #2980b9', // Border color
            padding: '20px', // Padding around the content
            marginBottom: '20px'}}><h3>Title: {question.title}</h3><h3>Question: {question.description}</h3></div>}
    <div>
        {isLoading ? "Loading..." : answers && answers.map((answer, i) => (
                <div key={i}>
                    <Answer answer={answer} index={i}/>
                    <button onClick={() => handleDelete(answer.id)}>Delete</button>
                </div>
            ))}

        </div>
        <form onSubmit={handleSubmit}>
            <label className={"messageLabel"}>Type your answer:
                <input className={"input"} type="text" value={message} onChange={e => setMessage(e.target.value)}/>
            </label>
            <button type="submit">Send Answer</button>
        </form>
    </div>
}

export default Answers;