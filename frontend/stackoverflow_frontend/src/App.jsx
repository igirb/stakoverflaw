import { useState } from 'react'
import './App.css'
import Questions from './Components/QuestionForm'

function App() {
    const [title, setTitle] = useState('')
    const [description, setDescription] = useState('')

    function handleSubmit(e) {
       // e.preventDefault()
        const data = { title, description }
        fetch('/api/question/add', {
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
            <h1>Stakkowerflov</h1>
            <form onSubmit={handleSubmit}>
                <label className={"titleLabel"}>Title:
                    <input className={"input"} type="text" value={title} onChange={e => setTitle(e.target.value)} />
                </label>
                <label className={"descriptionLabel"}>Question:
                    <input type='text' value={description} onChange={e => setDescription(e.target.value)}/>
                </label>
                <button type='submit'>Send Question</button>
            </form>
            <div className={"border"}> t</div>
            <Questions />
        </div>
    );
}

export default App;
