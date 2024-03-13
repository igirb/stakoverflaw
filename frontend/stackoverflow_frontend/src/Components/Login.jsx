import { useState, useEffect } from "react";

const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [showLogin, setShowLogin] = useState(false);
    const [loggedUser, setLoggedUser] = useState(null);

    useEffect(() => {
        const storedUser = localStorage.getItem('loggedUser');
        if (storedUser) {
            setLoggedUser(storedUser);
        }
    }, []);

    function handleSubmit(e) {
        e.preventDefault();
        const data = { username, password };
        fetch('/api/user/authenticate', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
            .then(response => response.json())
            .then(response => {
                if (response === true) {
                    setLoggedUser(username);
                    localStorage.setItem('loggedUser', username);
                } else {
                    setLoggedUser("You should register first");
                }
                setShowLogin(false);
                setUsername('');
                setPassword('');
            })
            .catch(err => {
                console.error(err);
            });
    }

    const handleLoginButton = () => {
        setShowLogin(!showLogin);
    };

    return (
        <div className="Login">
            <button className="LoginButton" onClick={handleLoginButton}>
                {showLogin ? 'Back' : 'Log in'}
            </button>
            {(loggedUser !== null) ? (<h1 className="loggedUser">Hello, {loggedUser}!</h1>) : (<h1 className="loggedUser">Hello Foreigner!</h1>)}
            {showLogin && (
                <form onSubmit={handleSubmit}>
                    <label>Name:
                        <input type="text" value={username} onChange={e => setUsername(e.target.value)} />
                    </label>
                    <label>Password:
                        <input type="password" value={password} onChange={e => setPassword(e.target.value)} />
                    </label>
                    <button type='submit'>Login</button>
                </form>
            )}
        </div>
    );
}

export default Login;
