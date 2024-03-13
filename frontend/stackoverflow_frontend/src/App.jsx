import { useState } from 'react';
import './App.css';
import Questions from './Components/QuestionForm';
import Registration from './Components/Registration.jsx';

function App() {
    const [title, setTitle] = useState('');
    const [description, setQuestion] = useState('');
    const [showRegistration, setShowRegistration] = useState(false);

    function handleSubmit(e) {
        const data = { title, description };
        fetch('/api/question/', {
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

    const handleRegistrationButton = () => {
        setShowRegistration(!showRegistration);
    };

    return (
        <div className="container">
            <button className="RegistrationButton" onClick={handleRegistrationButton}>
                {showRegistration ? 'Back' : 'Join'}
            </button>
            {showRegistration && <Registration onHide={handleRegistrationButton} />}
            <form onSubmit={handleSubmit}>
                <label>
                    Title:
                    <input type="text" value={title} onChange={(e) => setTitle(e.target.value)} />
                </label>
                <label>
                    Comment:
                    <input type="text" value={description} onChange={(e) => setQuestion(e.target.value)} />
                </label>
                <button type="submit">Send Question</button>
            </form>
            <Questions />
        </div>
    );
}

export default App;
