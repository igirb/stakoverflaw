import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'
import {createBrowserRouter, RouterProvider, useParams} from "react-router-dom";
import Questions from './Components/QuestionForm.jsx'
import Answers from './Components/Answers.jsx'

const router = createBrowserRouter([
    //const { id } = useParams()
    {
        path: "/",
        element: <App/>
    },
    {
        path: "/answer/question/:questionId",
        element: <Answers />
    },


]);

ReactDOM.createRoot(document.getElementById('root')).render(
    <React.StrictMode>
        <RouterProvider router={router}/>
    </React.StrictMode>,
)
