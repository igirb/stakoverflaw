import { useEffect, useState } from "react"
import Answer from "./Answer";
import {useParams} from "react-router-dom";

const fetchAnswers = async (questionId) => {
    const response = await fetch(`/api/answer/question/${questionId}`);
    if(response.ok){
        const data = response.json();
        console.log(data)
        return data;
    } else {
        throw new Error("Failed to fetch answers");
    }
}

const Answers = () => {
    const [answers, setAnswers] = useState(null);
    const [isLoading, setIsLoading] = useState(true);
    const {questionId} = useParams();
    const [message, setMessage] = useState("");
    console.log(questionId)

    useEffect(() => {
        fetchAnswers(questionId).then(data => {
            setAnswers(data);
            setIsLoading(false);
        })
    }, []);

    function handleSubmit() {
        const data = { message, questionId };
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
            })
            .catch((err) => {
                console.error(err);
            });
    }

    return <div>
        {isLoading ? "Loading..." : answers && answers.map((answer, i) => <Answer key={i} answer={answer}/>)}
        <form onSubmit={handleSubmit}>
            <label className={"messageLabel"}>Message:
                <input className={"input"} type="text" value={message} onChange={e => setMessage(e.target.value)}/>
            </label>
            <button type="submit">Send Answer</button>
        </form>
    </div>
}

export default Answers;