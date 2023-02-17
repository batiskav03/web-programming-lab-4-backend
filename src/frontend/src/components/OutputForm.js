import React from 'react'
import ReactDOM from 'react-dom'
import TextInput from './TextInput'
import Button from './Button'

export default function outputForm(props) {

    return (
        <form>
            <div>
                <TextInput 
                label={props.label[0]}
                handleFunc={props.inputFuncs[0]}
                type={props.type[0]}
                name={"username"}
                className="textinput"
                onKeyDown={props.onKeyDown}
                />
                <TextInput 
                label={props.label[1]}
                handleFunc={props.inputFuncs[1]}
                type={props.type[1]}
                name={"password"}
                className="textinput"
                onKeyDown={props.onKeyDown}
                />
                <div className='margin-left'>
                    <input type="button" className='submit-btn' onClick={props.btnFunc}  value={props.btnName} />
                </div>
            </div>
        </form>
    )
}