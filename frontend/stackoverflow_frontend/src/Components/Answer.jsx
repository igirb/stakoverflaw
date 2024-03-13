import { useState } from "react";

const Answer = ({answer}) => {
    
    return <div>
        <p>{answer.message}</p>
        <p>{answer.submission}</p>
        <p>{answer.id}</p>
    </div>
}

export default Answer;