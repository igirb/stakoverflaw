
import { useState } from 'react';
import './App.css';
import Questions from './Components/QuestionForm';
import Registration from './Components/Registration.jsx';

function App() {
    const [title, setTitle] = useState('');
    const [description, setDescription] = useState('')
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
          <h1>Stakkowerflov</h1>
            <button className="RegistrationButton" onClick={handleRegistrationButton}>
                {showRegistration ? 'Back' : 'Join'}
            </button>
            {showRegistration && <Registration onHide={handleRegistrationButton} />}
            <form onSubmit={handleSubmit}>
                <label className={"titleLabel"}>Title:
                    <input className={"input"} type="text" value={title} onChange={e => setTitle(e.target.value)} />
                </label>
                <label className={"descriptionLabel"}>Question:
                    <input type='text' value={description} onChange={e => setDescription(e.target.value)}/>
                </label>
                <button type="submit">Send Question</button>
            </form>
            <div className={"border"}> t</div>
            <Questions />
        </div>
    );
}

export default App;
