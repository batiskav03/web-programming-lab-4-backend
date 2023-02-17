import React from 'react'
import ReactDOM from 'react-dom'

export default function TextInput(props) {
    return(
        <div>
            <label className={"white-label"}>{props.label}</label>
            <input
            onKeyDown={props.onKeyDown}
            onChange={props.handleFunc}
            type={props.type}
            name={props.name}
            className={props.className}
            />
        </div>
    )
}