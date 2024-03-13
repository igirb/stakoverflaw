
import { useState } from 'react'
import './App.css'
import Questions from './Components/QuestionForm';
import Answers from './Components/Answers';
import Registration from './Components/Registration.jsx';
import Users from "./Components/Users.jsx";
import Login from "./Components/Login.jsx";

function App() {
    const [title, setTitle] = useState('');
    const [description, setDescription] = useState('')

    function handleSubmit(e) {
        const data = { title, description };
        fetch('/api/question/add', {

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

    return (
        <div className="container">
          <h1>STAKKOWERFLOV</h1>
            <Registration />
            <Login />
            <form onSubmit={handleSubmit}>
                <label className={"titleLabel"}>Title:
                    <input className={"input"} type="text" value={title} onChange={e => setTitle(e.target.value)} />
                </label>
                <label className={"descriptionLabel"}>Question:
                    <input type='text' value={description} onChange={e => setDescription(e.target.value)}/>
                </label>
                <button type="submit">Send Question</button>
            </form>
            <Questions />
            <Users />
        </div>
    );
}

export default App;
