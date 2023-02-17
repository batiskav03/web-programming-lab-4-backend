import {React, useState} from 'react'
import ReactDOM from 'react-dom'
import '../css/authStyle.css'

import OutputForm from '../components/OutputForm'



export default function LoginPage() {
    const [login, setLogin] = useState("")
    const [password, setPassword] = useState("")
    const [isRegister, setIsRegister] = useState(false)

    function handleLogin(evt) {
        setLogin(evt.target.value)
    }

    function handlePassword(evt) {
        setPassword(evt.target.value)
    }

    function handleButtonClick(evt) {
        evt.preventDefault()
        let data = JSON.stringify({
            login: login,
            password: password,
        })
        fetch("http://localhost:8080/register",{
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: data,
        })
    }

    function handleCheckBox(evt) {
        setIsRegister(!isRegister)
    }
    
    return (
        <div className='formContainer'>
            <input type="checkbox"
            onClick={handleCheckBox}
            checked={isRegister}/>
            <label className='subtitle'>Регистрация/Вход</label>
            <div className='formContainer' style={isRegister ? {display: 'none'}: {display: ''}}>
                <div className='title'>
                    Войти:
                </div>
            <form method="post" action="/login">
                <div className="input-container ic1">
                    <input id="firstname" className="input" type="text"  name="username" placeholder="Username"  />
                </div>
                
                <div class="input-container ic2">
                    <input id="lastname" className="input" type="password" name="password" placeholder="Password"  />
                </div>
                
                <div>
                    <button className='submit' type="submit">{!isRegister ? "Log in" : "Sign up"}</button>
                </div>
                
            </form>
            </div>
            <div className='formContainer' style={!isRegister ? {display: "none"}: {display: ''}}>
                <div  className='title'>
                    Регистрация:
                </div>
            <form>
                <div className="input-container ic1">
                    <input id="firstname" className="input" type="text" name="username" placeholder="Username" onChange={handleLogin}/>
                </div>
                <div className="input-container ic2">
                    <input id="lastname" className="input" type="password"  name="password"  placeholder="Password"  onChange={handlePassword} />
                </div>
                <div>
                <button className="submit"  onClick={(evt) => {
                    handleButtonClick(evt)
                    handleCheckBox()
                    }}>{!isRegister ? "Log in" : "Sign up"}</button>
                </div>
            </form>
            </div>
        </div>
        )
}