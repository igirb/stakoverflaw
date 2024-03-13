import { useState } from 'react'
import './App.css'
import Questions from './Components/QuestionForm'
import Answers from './Components/Answers'

function App() {
    const [title, setTitle] = useState('')
    const [description, setQuestion] = useState('')
    const [show, setShow] = useState(false);

    function handleSubmit(e) {
        e.preventDefault()
        const data = { title, description }
        fetch('/api/question/', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
            .then(response => response.json())
            .then(response => {
                console.log(response);
            })
            .catch(err => {
                console.error(err);
            })
    }

    return (
        <div className="App">
            <form onSubmit={handleSubmit}>
                <label>Title:
                    <input type="text" value={title} onChange={e => setTitle(e.target.value)} />
                </label>
                <label>Comment:
                    <input type='text' value={description} onChange={e => setQuestion(e.target.value)}/>
                </label>
                <button type='submit'>Send Question</button>
            </form>
            <Questions />
            <button onClick={() => setShow(true)} >Show answers</button>
            { !show ? "" : <Answers questionId={question.id} /> }
        </div>
    );
}

export default App;
