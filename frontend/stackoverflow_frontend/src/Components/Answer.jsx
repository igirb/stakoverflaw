import { useState } from "react";

const Answer = ({answer, index}) => {
    
    return <div>
        <h3>{index + 1}. Answer: {answer.message}</h3>
    </div>
}

export default Answer;