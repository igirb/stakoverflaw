import { useState } from "react";

const Registration = () => {
    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')

    function handleSubmit(e) {
        const data = { username, password }
        fetch('/api/user/', {
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
        <div className="Registration">
            <form onSubmit={handleSubmit}>
                <label>Name:
                    <input type="text" value={username} onChange={e => setUsername(e.target.value)}/>
                </label>
                <label>Password:
                    <input type="password" value={password} onChange={e => setPassword(e.target.value)}/>
                </label>
                <button type='submit'>Register</button>
            </form>
        </div>
    );
}

export default Registration;