import { useEffect, useState } from "react"
import Answer from "./Answer";

const fetchAnswers = async (questionId) => {
    const response = await fetch(`/api/answer/question/${questionId}`);
    const data = response.json();
    return data;
}

const Answers = ({ questionId }) => {
    const [answers, setAnswers] = useState(null);
    const [isLoading, setIsLoading] = useState(true);

    useEffect(() => {
        fetchAnswers(questionId).then(data => {
            setAnswers(data);
            setIsLoading(false);
        })
    }, []);

    return <div>
        {isLoading ? "Loading..." : answers.map((answer, i) => <Answer key={i} answer={answer} />)}
    </div>
}

export default Answers;