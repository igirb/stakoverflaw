import {useEffect, useState} from "react";
import {Link} from "react-router-dom";

const Users = () => {
    const [displayUsers, setDisplayUsers] = useState([]);

    useEffect(() => {
            fetch("/api/user/all")
                .then((response) => {
                    return response.json();
                })
                .then((response) => {
                    setDisplayUsers(response);
                })
                .catch((error) => {
                    console.error(error);
                });
        },
        []);
    const handleDelete = (id) => {
        fetch(`/api/user/${id}`, {
            method: 'DELETE'
        })
            .then(() => {
                setDisplayUsers(prevUsers => prevUsers.filter(user => user.id !== id));
                window.location.reload();
            })
            .catch(error => console.error(error));
    }

    return (
        <div className="users">
            <h3 className="users_headline">Users currently online</h3>
                <div>
                    {displayUsers.map((user, index) => (
                        <div key={index}>
                            <h3>Name: {user.username}</h3>
                            <button onClick={() => handleDelete(user.id)}>Delete</button>
                        </div>
                    ))}
                </div>
            <Link to={"/"}>
            <button>Back</button>
            </Link>
        </div>
    );
};

export default Users;