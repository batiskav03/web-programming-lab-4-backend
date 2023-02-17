import React from 'react'
import ReactDOM from 'react-dom'

function Footer(props) {
    return (
        <div>
            <h3>
                <p className='white-label'>{props.name}</p>
                <p className='white-label'>{props.group}</p>
                <p className='white-label'>{props.task}</p>
            </h3>
        </div>
    )
}

export default Footer