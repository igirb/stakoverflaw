import { useState } from 'react'
import './App.css'
import Questions from './components/QuestionForm'

function App() {
    const [title, setTitle] = useState('')
    const [description, setQuestion] = useState('')

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
        </div>
    );
}

export default App;
